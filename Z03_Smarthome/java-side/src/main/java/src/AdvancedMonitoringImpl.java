package src;

import com.google.protobuf.Any;
import com.google.rpc.Status;
import generated.*;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import model.*;
import repository.DeviceRepository;

public class AdvancedMonitoringImpl extends AdvancedMonitoringGrpc.AdvancedMonitoringImplBase {

    private DeviceRepository repository;

    public AdvancedMonitoringImpl(DeviceRepository repository) {
        this.repository = repository;
    }

    private CameraBase findCamera(int id) throws Exception {
        for (DeviceBase device : repository.getDevices()) {
            if (device.getId() == id) {

                if (device instanceof CameraBase camera) {
                    return camera;
                }

                throw new Exception("UNSUPPORTED");
            }
        }

        throw new Exception("NOT_FOUND");
    }

    private generated.Status ok() {
        return generated.Status.newBuilder()
                .setStatus(StatusEnum.OK)
                .build();
    }

    private void sendNotFound(StreamObserver<?> observer, int id) {

        DeviceError detail = DeviceError.newBuilder()
                .setNotFound(
                        DeviceNotFoundError.newBuilder()
                                .setId(id)
                                .setMsg("Device not found")
                                .build()
                )
                .build();

        Status status = Status.newBuilder()
                .setCode(io.grpc.Status.NOT_FOUND.getCode().value())
                .setMessage("Device not found")
                .addDetails(Any.pack(detail))
                .build();

        observer.onError(StatusProto.toStatusRuntimeException(status));
    }

    private void sendUnsupported(StreamObserver<?> observer,
                                 int id,
                                 String name,
                                 String msg) {

        DeviceError detail = DeviceError.newBuilder()
                .setUnsupported(
                        UnsupportedOperationError.newBuilder()
                                .setId(id)
                                .setName(name)
                                .setMsg(msg)
                                .build()
                )
                .build();

        Status status = Status.newBuilder()
                .setCode(io.grpc.Status.UNIMPLEMENTED.getCode().value())
                .setMessage(msg)
                .addDetails(Any.pack(detail))
                .build();

        observer.onError(StatusProto.toStatusRuntimeException(status));
    }

    private void sendInvalid(StreamObserver<?> observer,
                             int id,
                             String name,
                             String msg) {

        DeviceError detail = DeviceError.newBuilder()
                .setInvalid(
                        InvalidArgumentError.newBuilder()
                                .setId(id)
                                .setName(name)
                                .setMsg(msg)
                                .build()
                )
                .build();

        Status status = Status.newBuilder()
                .setCode(io.grpc.Status.INVALID_ARGUMENT.getCode().value())
                .setMessage(msg)
                .addDetails(Any.pack(detail))
                .build();

        observer.onError(StatusProto.toStatusRuntimeException(status));
    }

    private boolean isIndoor(CameraType type) {
        return type == CameraType.INDOOR;
    }

    private boolean isOutdoor(CameraType type) {
        return type == CameraType.OUTDOOR;
    }

    private boolean isThermal(CameraType type) {
        return type == CameraType.THERMAL;
    }

    @Override
    public void setPrivacyMode(PrivacyRequest request,
                               StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            if (!isIndoor(camera.getCameraType())) {
                sendUnsupported(responseObserver, id,
                        camera.getName(),
                        "Privacy mode supported only for INSIDE camera");
                return;
            }

            IndoorCamera indoor = (IndoorCamera)camera;

            indoor.setPrivacyMode(request.getMode());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Camera", e.getMessage());
            }
        }
    }

    @Override
    public void playAudio(AudioRequest request,
                          StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            if (!isIndoor(camera.getCameraType())) {
                sendUnsupported(responseObserver, id,
                        camera.getName(),
                        "Audio playback supported only for INSIDE camera");
                return;
            }

            if (request.getRepeat() < 1) {
                sendInvalid(responseObserver, id,
                        camera.getName(),
                        "Repeat must be >= 1");
                return;
            }

            IndoorCamera indoor = (IndoorCamera)camera;

            for (int i = 0; i < request.getRepeat(); ++i) {
                indoor.playAudio(new AudioInfo(request.getAudioUrl(), 27, 213));
            }

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Camera", e.getMessage());
            }
        }
    }

    @Override
    public void setWeatherMode(WeatherRequest request,
                               StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            if (!isOutdoor(camera.getCameraType())) {
                sendUnsupported(responseObserver, id,
                        camera.getName(),
                        "Weather mode supported only for OUTSIDE camera");
                return;
            }

            OutdoorCamera outdoor = (OutdoorCamera)camera;

            if (request.getEnabled()) {
                outdoor.turnOnWeatherMode();
            } else {
                outdoor.turnOffWeatherMode();
            }

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Camera", e.getMessage());
            }
        }
    }


    @Override
    public void disableTemperatureAlarm(DeviceId request,
                                        StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            if (!isThermal(camera.getCameraType())) {
                sendUnsupported(responseObserver, id,
                        camera.getName(),
                        "Temperature alarm supported only for THERMOVISION camera");
                return;
            }

            ThermalCamera thermal = (ThermalCamera)camera;
            thermal.disableAlarm();

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Camera", e.getMessage());
            }
        }
    }

    @Override
    public void setTemperatureAlarm(TemperatureAlarmRequest request,
                                    StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            if (!isThermal(camera.getCameraType())) {
                sendUnsupported(responseObserver, id,
                        camera.getName(),
                        "Temperature alarm supported only for THERMOVISION camera");
                return;
            }

            ThermalCamera thermal = (ThermalCamera)camera;
            thermal.setAlarm(request.getThreshold());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Camera", e.getMessage());
            }
        }
    }

    @Override
    public void setTemperatureRange(TemperatureRangeRequest request,
                                    StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            if (!isThermal(camera.getCameraType())) {
                sendUnsupported(responseObserver, id,
                        camera.getName(),
                        "Temperature range supported only for THERMOVISION camera");
                return;
            }

            ThermalCamera thermal = (ThermalCamera)camera;
            thermal.setTemperatureRange(
                    request.getMin(),
                    request.getMax()
            );

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Camera", e.getMessage());
            }
        }
    }

}
