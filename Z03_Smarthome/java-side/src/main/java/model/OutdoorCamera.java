package model;

import generated.CameraType;

public class OutdoorCamera extends CameraBase {
    private boolean weatherEnabled;

    public OutdoorCamera(int id, String name) {
        super(id, name, CameraType.OUTDOOR);

        this.weatherEnabled = false;
    }

    public void turnOnWeatherMode() {
        if (this.weatherEnabled) {
            System.out.println("Weather mode is already ON");
        } else {
            System.out.println("Enabling weather mode on " + this.name);
            this.weatherEnabled = true;
        }
    }

    public void turnOffWeatherMode() {
        if (!this.weatherEnabled) {
            System.out.println("Weather mode is already OFF");
        } else {
            System.out.println("Disabling weather mode on " + this.name);
        }
    }
}
