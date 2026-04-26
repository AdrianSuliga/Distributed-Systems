package model;

import generated.Animation;
import generated.LightType;

public class LEDStrip extends LightBase {
    private Animation currentAnimation;

    public LEDStrip(int id, String name) {
        super(id, name, LightType.LED_STRIP);
        this.currentAnimation = Animation.NOT_SET;
    }

    public void setAnimation(Animation newAnimation) {
        System.out.println("Setting animation for " + this.name);
        this.currentAnimation = newAnimation;
    }
}
