package model;

import generated.Effect;
import generated.LightType;

public class RGBLamp extends LightBase {
    private RGB color;
    private int hue;
    private Effect currentEffect;

    public RGBLamp(int id, String name) {
        super(id, name, LightType.RGB_LAMP);
        this.color = new RGB(0, 0, 0);
        this.hue = 0;
        this.currentEffect = Effect.NONE;
    }

    public void setColor(int red, int green, int blue) throws Exception {
        if ((red < 0 || red > 255) || (green < 0 || green > 255) || (blue < 0 || blue > 255)) {
            throw new Exception("RGB values must be 0 - 255");
        }

        this.color = new RGB(red, green, blue);
    }

    public void setHue(int newHue) throws Exception {
        if (newHue < 0 || newHue > 360) {
            throw new Exception("Hue values must be 0 - 360");
        }

        this.hue = newHue;
    }

}
