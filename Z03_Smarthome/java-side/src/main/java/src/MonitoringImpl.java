package src;

import generated.*;
import io.grpc.stub.StreamObserver;
import model.*;
import repository.DeviceRepository;
import com.google.rpc.Status;
import com.google.protobuf.Any;
import io.grpc.protobuf.StatusProto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class MonitoringImpl extends MonitoringGrpc.MonitoringImplBase {

    private DeviceRepository repository;

    public MonitoringImpl(DeviceRepository repository) {
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

    @Override
    public void move(MoveRequest request,
                     StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            camera.setPTZ(
                    request.getPan(),
                    request.getTilt(),
                    request.getZoom()
            );

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (IllegalArgumentException e) {
            sendInvalid(responseObserver, id, "Camera", e.getMessage());

        } catch (Exception e) {
            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Device", e.getMessage());
            }
        }
    }

    @Override
    public void captureImage(CaptureOneRequest request,
                             StreamObserver<Image> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            ImageInfo info = camera.captureImage(request.getFormat());

            Image image = Image.newBuilder()
                    .setUrl(info.url())
                    .setWidth(info.width())
                    .setHeight(info.height())
                    .setSize(info.size())
                    .build();

            responseObserver.onNext(image);
            responseObserver.onCompleted();

        } catch (Exception e) {
            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Device",
                        e.getMessage());
            }
        }
    }

    @Override
    public void captureImages(CaptureManyRequest request,
                             StreamObserver<Images> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            List<ImageInfo> info = camera.captureImages(request.getFormatsList());

            Images.Builder response = Images.newBuilder();

            for (ImageInfo img : info) {

                Image image = Image.newBuilder()
                        .setUrl(img.url())
                        .setWidth(img.width())
                        .setHeight(img.height())
                        .setSize(img.size())
                        .build();

                response.addImages(image);
            }

            responseObserver.onNext(response.build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Device", e.getMessage());
            }
        }
    }

    @Override
    public void startRecording(DeviceId request,
                               StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            camera.startRecording();

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {
            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Device",
                        e.getMessage());
            }
        }
    }

    @Override
    public void endRecording(DeviceId request,
                             StreamObserver<Recording> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            RecordingInfo info = camera.stopRecording();

            Recording rec = Recording.newBuilder()
                    .setUrl(info.url())
                    .setLength(info.length())
                    .setSize(info.size())
                    .build();

            responseObserver.onNext(rec);
            responseObserver.onCompleted();

        } catch (Exception e) {
            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Device",
                        e.getMessage());
            }
        }
    }

    @Override
    public void configurePatrol(PatrolRequest request,
                                StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            CameraBase camera = findCamera(id);

            List<PatrolPointInfo> patrolPoints = new ArrayList<>();

            for (PatrolPoint p : request.getPointsList()) {

                PTZ ptz = new PTZ(
                        p.getPan(),
                        p.getTilt(),
                        p.getZoom()
                );

                PatrolPointInfo point =
                        new PatrolPointInfo(ptz, p.getStayTime());

                patrolPoints.add(point);
            }

            List<LocalTime> activeHours = new ArrayList<>();

            for (Time t : request.getActiveList()) {

                LocalTime time = LocalTime.of(
                        t.getHour(),
                        t.getMinute(),
                        t.getSecond()
                );

                activeHours.add(time);
            }

            camera.setPatrolRoute(patrolPoints, activeHours);

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "Device", e.getMessage());
            }
        }
    }
}
