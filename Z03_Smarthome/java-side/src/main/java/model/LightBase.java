package model;

import generated.DeviceType;
import generated.LightType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class LightBase extends DeviceBase {
    /* 0 - 100 */
    protected int brightness;
    protected List<PowerUsageRecord> stats = new ArrayList<>();
    protected LightType lightType;

    public LightBase(int id, String name, LightType lightType) {
        super(id, name, DeviceType.LIGHT);
        this.brightness = 0;
        this.lightType = lightType;
    }

    public LightType getLightType() {
        return this.lightType;
    }

    public void setBrightness(int newBrightness) throws Exception {
        if (newBrightness < 0 || newBrightness > 100) {
            throw new Exception("Brightness value out of range");
        }

        System.out.println("Setting brightness of " + this.name + " to " + newBrightness);
        this.brightness = newBrightness;
    }

    public void toggle() {
        if (this.isOn) {
            off();
        } else {
            on();
        }
    }

    public void addPowerUsageRecord(PowerUsageRecord newRecord) {
        System.out.println("Adding new power usage record to " + this.name);
        stats.add(newRecord);
    }

    public void cleanPowerUsageStats() {
        stats.clear();
    }

    public List<PowerUsageRecord> getPowerUsageStats() {
        System.out.println("Getting power stats from " + this.name);
        return this.stats;
    }

    public void scheduleOn(LocalDateTime time) throws Exception {
        if (time.isBefore(LocalDateTime.now())) {
            throw new Exception("Cannot schedule ON in the past");
        }
        System.out.println("Scheduling time ON for " + this.name);
    }

    public void scheduleOff(LocalDateTime time) throws Exception {
        if (time.isBefore(LocalDateTime.now())) {
            throw new Exception("Cannot schedule OFF in the past");
        }
        System.out.println("Scheduling time OFF for " + this.name);
    }

}
