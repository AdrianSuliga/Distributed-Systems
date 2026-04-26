package model;

import generated.DetectionMode;
import generated.LightType;
import generated.SensitivityMode;

public class OutdoorLamp extends LightBase {
    private DetectionMode detectionMode;
    private SensitivityMode sensitivityMode;
    private boolean weatherMode;

    public OutdoorLamp(int id, String name) {
        super(id, name, LightType.OUTDOOR_LAMP);
        this.detectionMode = DetectionMode.RANGE_10M;
        this.sensitivityMode = SensitivityMode.SMALL;
        this.weatherMode = false;
    }

    public void setMotionDetectionMode(DetectionMode newMode) {
        System.out.println("Setting detection mode for " + this.name);
        this.detectionMode = newMode;
    }

    public void setSensitivityLevel(SensitivityMode newMode) {
        System.out.println("Setting sensitivity mode for " + this.name);
        this.sensitivityMode = newMode;
    }

    public void turnOnWeatherMode() {
        if (this.weatherMode) {
            System.out.println("Weather mode is already enabled");
        } else {
            this.weatherMode = true;
        }
    }

    public void turnOffWeatherMode() {
        if (!this.weatherMode) {
            System.out.println("Weather mode is already disabled");
        } else {
            this.weatherMode = false;
        }
    }

}
