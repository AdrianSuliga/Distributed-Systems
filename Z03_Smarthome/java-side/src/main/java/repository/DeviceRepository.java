package repository;

import model.DeviceBase;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepository {
    private List<DeviceBase> devices = new ArrayList<>();

    public DeviceRepository() {

    }

    public void addDevice(DeviceBase device) {
        devices.add(device);
    }

    public List<DeviceBase> getDevices() {
        return this.devices;
    }
}
