package src;

import generated.*;
import io.grpc.protobuf.StatusProto;
import model.DeviceBase;
import repository.DeviceRepository;

import java.util.List;

public class DeviceImpl extends DeviceGrpc.DeviceImplBase {

    private final DeviceRepository repository;

    public DeviceImpl(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void turnON(DeviceId request, io.grpc.stub.StreamObserver<Status> responseObserver) {
        int id = request.getId();

        List<DeviceBase> devices = repository.getDevices();

        for (DeviceBase device : devices) {
            if (device.getId() == id) {
                device.on();

                Status response = Status.newBuilder()
                        .setStatus(StatusEnum.OK)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
        }

        DeviceError detail = DeviceError.newBuilder()
                .setNotFound(
                        DeviceNotFoundError.newBuilder()
                                .setId(id)
                                .setMsg("Device not found")
                                .build()
                ).build();

        com.google.rpc.Status rpcStatus =
                com.google.rpc.Status.newBuilder()
                        .setCode(io.grpc.Status.NOT_FOUND.getCode().value())
                        .setMessage("Device not found")
                        .addDetails(com.google.protobuf.Any.pack(detail))
                        .build();

        responseObserver.onError(StatusProto.toStatusRuntimeException(rpcStatus));
    }

    @Override
    public void turnOFF(DeviceId request, io.grpc.stub.StreamObserver<Status> responseObserver) {
        int id = request.getId();

        for (DeviceBase device : repository.getDevices()) {
            if (device.getId() == id) {

                device.off();

                Status response = Status.newBuilder()
                        .setStatus(StatusEnum.OK)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
        }

        DeviceError detail = DeviceError.newBuilder()
                .setNotFound(
                        DeviceNotFoundError.newBuilder()
                                .setId(id)
                                .setMsg("Device not found")
                                .build()
                )
                .build();

        com.google.rpc.Status rpcStatus =
                com.google.rpc.Status.newBuilder()
                        .setCode(io.grpc.Status.NOT_FOUND.getCode().value())
                        .setMessage("Device not found")
                        .addDetails(com.google.protobuf.Any.pack(detail))
                        .build();

        responseObserver.onError(StatusProto.toStatusRuntimeException(rpcStatus));
    }
}
