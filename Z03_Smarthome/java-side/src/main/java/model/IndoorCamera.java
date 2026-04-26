package model;

import generated.CameraType;
import generated.PrivacyMode;

public class IndoorCamera extends CameraBase {
    private PrivacyMode mode;

    public IndoorCamera(int id, String name) {
        super(id, name, CameraType.INDOOR);
        this.mode = PrivacyMode.OFF;
    }

    public void setPrivacyMode(PrivacyMode newMode) {
        System.out.println("Setting privacy mode for " + this.name);

        this.mode = newMode;
    }

    public void playAudio(AudioInfo recording) {
        System.out.println("Playing audio on " + this.name);
        System.out.println(recording.url() + " length " + recording.length() + " s (" + recording.size() + " kB)");
    }
}
