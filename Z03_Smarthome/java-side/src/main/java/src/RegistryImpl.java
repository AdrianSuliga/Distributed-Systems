package src;

import generated.*;
import model.CameraBase;
import model.DeviceBase;
import model.LightBase;
import repository.DeviceRepository;

public class RegistryImpl extends RegistryGrpc.RegistryImplBase {

    private final DeviceRepository repository;

    public RegistryImpl(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void listDevices(Empty request, io.grpc.stub.StreamObserver<DeviceList> responseObserver) {
        System.out.println("listDevices request ()");

        DeviceList.Builder response = DeviceList.newBuilder();

        for (DeviceBase device : this.repository.getDevices()) {
            switch (device.getDeviceType()) {
                case DeviceType.LIGHT -> {
                    LightBase lightDevice = (LightBase)device;

                    LightDeviceInfo.Builder lightInfo = LightDeviceInfo.newBuilder()
                            .setId(device.getId())
                            .setName(device.getName())
                            .setType(lightDevice.getLightType());

                    response.addLightDevices(lightInfo.build());
                }

                case DeviceType.CAMERA -> {
                    CameraBase cameraDevice = (CameraBase)device;

                    CameraDeviceInfo.Builder cameraInfo = CameraDeviceInfo.newBuilder()
                            .setId(device.getId())
                            .setName(device.getName())
                            .setType(cameraDevice.getCameraType());

                    response.addCameraDevices(cameraInfo.build());
                }

                default -> {
                    System.out.println("How did we get here?");
                }
            }
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
