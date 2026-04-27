package src;

import com.google.protobuf.Any;
import generated.*;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import com.google.rpc.Status;
import model.*;
import repository.DeviceRepository;

public class AdvancedLightImpl extends AdvancedLightGrpc.AdvancedLightImplBase {

    private DeviceRepository repository;

    public AdvancedLightImpl(DeviceRepository repository) {
        this.repository = repository;
    }

    private LightBase findLight(int id) throws Exception {
        for (DeviceBase device : repository.getDevices()) {
            if (device.getId() == id) {

                if (device instanceof LightBase light) {
                    return light;
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

    @Override
    public void setRGB(RGBRequest request,
                       StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            if (light.getLightType() != LightType.RGB_LAMP) {
                sendUnsupported(responseObserver, id,
                        light.getName(),
                        "setRGB supported only for RGB_LAMP");
                return;
            }

            RGBLamp lamp = (RGBLamp)light;

            lamp.setColor(
                    request.getRed(),
                    request.getGreen(),
                    request.getBlue()
            );

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "RGB", e.getMessage());
            }
        }
    }

    @Override
    public void setHue(HueRequest request,
                       StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            if (light.getLightType() != LightType.RGB_LAMP) {
                sendUnsupported(responseObserver, id,
                        light.getName(),
                        "setHue supported only for RGB_LAMP");
                return;
            }

            RGBLamp lamp = (RGBLamp)light;

            lamp.setHue(request.getHue());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "RGB", e.getMessage());
            }
        }
    }

    @Override
    public void setEffect(EffectRequest request,
                          StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            if (light.getLightType() != LightType.RGB_LAMP) {
                sendUnsupported(responseObserver, id,
                        light.getName(),
                        "setEffect supported only for RGB_LAMP");
                return;
            }

            RGBLamp lamp = (RGBLamp)light;

            lamp.setEffect(request.getEffect());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendUnsupported(responseObserver, id, "unknown", e.getMessage());
            }
        }
    }

    @Override
    public void setStripAnimation(AnimationRequest request,
                                  StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            if (light.getLightType() != LightType.LED_STRIP) {
                sendUnsupported(responseObserver, id,
                        light.getName(),
                        "setStripAnimation supported only for LED_STRIP");
                return;
            }

            LEDStrip led = (LEDStrip)light;
            led.setAnimation(request.getAnimation());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendUnsupported(responseObserver, id, "unknown", e.getMessage());
            }
        }
    }

    @Override
    public void setMotionDetecion(MotionRequest request,
                                  StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            if (light.getLightType() != LightType.OUTDOOR_LAMP) {
                sendUnsupported(responseObserver, id,
                        light.getName(),
                        "setMotionDetection supported only for OUTDOOR_LAMP");
                return;
            }

            OutdoorLamp lamp = (OutdoorLamp)light;
            lamp.setMotionDetectionMode(request.getMode());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendUnsupported(responseObserver, id, "unknown", e.getMessage());
            }
        }
    }

    @Override
    public void setMotionSensitivity(SensitivityRequest request,
                                     StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            if (light.getLightType() != LightType.OUTDOOR_LAMP) {
                sendUnsupported(responseObserver, id,
                        light.getName(),
                        "setMotionSensitivity supported only for OUTDOOR_LAMP");
                return;
            }

            OutdoorLamp lamp = (OutdoorLamp)light;
            lamp.setSensitivityLevel(request.getMode());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendUnsupported(responseObserver, id, "unknown", e.getMessage());
            }
        }
    }

    @Override
    public void setWeatherMode(WeatherRequest request,
                               StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            if (light.getLightType() != LightType.OUTDOOR_LAMP) {
                sendUnsupported(responseObserver, id,
                        light.getName(),
                        "setWeatherMode supported only for OUTDOOR_LAMP");
                return;
            }

            OutdoorLamp lamp = (OutdoorLamp)light;
            if (request.getEnabled()) {
                lamp.turnOnWeatherMode();
            } else {
                lamp.turnOffWeatherMode();
            }

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendUnsupported(responseObserver, id, "unknown", e.getMessage());
            }
        }
    }

}
