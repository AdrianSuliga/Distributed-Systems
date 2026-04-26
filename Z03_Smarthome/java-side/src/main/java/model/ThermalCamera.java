package model;

import generated.CameraType;

public class ThermalCamera extends CameraBase {
    private boolean alarmSet;
    private double threshold, rangeMin, rangeMax;

    public ThermalCamera(int id, String name) {
        super(id, name, CameraType.THERMAL);

        this.alarmSet = false;
        this.threshold = 0.0;
        this.rangeMin = Double.MAX_VALUE;
        this.rangeMax = Double.MIN_VALUE;
    }

    public void setAlarm(double threshold) {
        System.out.println("Setting alarm on " + this.name);

        this.alarmSet = true;
        this.threshold = threshold;
    }

    public void disableAlarm() {
        System.out.println("Disabling alarm on " + this.name);

        this.alarmSet = false;
    }

    public void setTemperatureRange(double newMin, double newMax) throws Exception {
        System.out.println("Setting temperature range on " + this.name);

        if (newMin >= newMax) {
            throw new Exception("Min should be less than max");
        }

        this.rangeMin = newMin;
        this.rangeMax = newMax;
    }
}
