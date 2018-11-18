package org.lvjing.Component;

/**
 * 攻击速度
 */
public class AttackSpeed {

    private int speed;

    public void setSpeed(int attackSpeed) {
        this.speed = attackSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "AttackSpeed{" +
                "speed=" + speed +
                '}';
    }
}
