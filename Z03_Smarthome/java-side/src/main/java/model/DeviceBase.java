package model;

import generated.DeviceType;

public abstract class DeviceBase {
    protected boolean isOn = false;
    protected String name;
    protected int id;
    protected DeviceType deviceType;

    public DeviceBase(int id, String name, DeviceType deviceType) {
        this.id = id;
        this.name = name;
        this.deviceType = deviceType;
    }

    public void on() {
        if (isOn) {
            System.out.println("Device " + name + " is already ON");
        } else {
            System.out.println("Turning ON " + name);
            isOn = true;
        }
    }

    public void off() {
        if (!isOn) {
            System.out.println("Device " + name + " is already OFF");
        } else {
            System.out.println("Turning OFF " + name);
            isOn = false;
        }
    }

    public boolean isOn() {
        return this.isOn;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public DeviceType getDeviceType() {
        return this.deviceType;
    }
}
