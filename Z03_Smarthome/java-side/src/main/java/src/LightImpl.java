package src;

import com.google.protobuf.Any;
import com.google.rpc.Status;
import generated.*;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import model.DeviceBase;
import model.LightBase;
import model.PowerUsageRecord;
import repository.DeviceRepository;

import java.time.LocalDateTime;

public class LightImpl extends LightGrpc.LightImplBase {

    private final DeviceRepository repository;

    public LightImpl(DeviceRepository repository) {
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

    private LocalDateTime fromProto(Time t) {
        return LocalDateTime.of(
                t.getYear(),
                t.getMonth(),
                t.getDay(),
                t.getHour(),
                t.getMinute(),
                t.getSecond()
        );
    }

    private Time toProto(LocalDateTime dt) {
        return Time.newBuilder()
                .setYear(dt.getYear())
                .setMonth(dt.getMonthValue())
                .setDay(dt.getDayOfMonth())
                .setHour(dt.getHour())
                .setMinute(dt.getMinute())
                .setSecond(dt.getSecond())
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

    private void sendUnsupported(StreamObserver<?> observer, int id, String name) {

        DeviceError detail = DeviceError.newBuilder()
                .setUnsupported(
                        UnsupportedOperationError.newBuilder()
                                .setId(id)
                                .setName(name)
                                .setMsg("Device does not support this operation")
                                .build()
                )
                .build();

        Status status = Status.newBuilder()
                .setCode(io.grpc.Status.UNIMPLEMENTED.getCode().value())
                .setMessage("Unsupported operation")
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
    public void toggle(DeviceId request,
                       StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            light.toggle();

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendUnsupported(responseObserver, id, "unknown");
            }
        }
    }

    @Override
    public void setBrightness(BrigthnessRequest request,
                              StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            light.setBrightness(request.getBrightness());

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (IllegalArgumentException e) {

            sendInvalid(responseObserver, id, "Light", e.getMessage());

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "light", "Invalid");
            }
        }
    }

    @Override
    public void getPowerUsage(DeviceId request,
                              StreamObserver<PowerUsageStats> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            PowerUsageStats.Builder result =
                    PowerUsageStats.newBuilder()
                            .setId(id);

            for (PowerUsageRecord record : light.getPowerUsageStats()) {

                result.addStats(
                        PowerUsageStatsPerDay.newBuilder()
                                .setTime(toProto(record.getTime()))
                                .setConsumption(record.getConsumption())
                                .build()
                );
            }

            responseObserver.onNext(result.build());
            responseObserver.onCompleted();

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendUnsupported(responseObserver, id, "unknown");
            }
        }
    }

    @Override
    public void scheduleON(ScheduleRequest request,
                           StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            light.scheduleOn(fromProto(request.getTime()));

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (IllegalArgumentException e) {

            sendInvalid(responseObserver, id, "Light", e.getMessage());

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "light", "Invalid");
            }
        }
    }

    @Override
    public void scheduleOFF(ScheduleRequest request,
                            StreamObserver<generated.Status> responseObserver) {

        int id = request.getId();

        try {
            LightBase light = findLight(id);

            light.scheduleOff(fromProto(request.getTime()));

            responseObserver.onNext(ok());
            responseObserver.onCompleted();

        } catch (IllegalArgumentException e) {

            sendInvalid(responseObserver, id, "Light", e.getMessage());

        } catch (Exception e) {

            if (e.getMessage().equals("NOT_FOUND")) {
                sendNotFound(responseObserver, id);
            } else {
                sendInvalid(responseObserver, id, "light", "Invalid");
            }
        }
    }
}