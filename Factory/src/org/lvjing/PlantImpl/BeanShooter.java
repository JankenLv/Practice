package org.lvjing.PlantImpl;

import org.lvjing.Component.HP;
import org.lvjing.Component.Hair;
import org.lvjing.Plant.Plant;

public class BeanShooter extends Plant {

    private HP hp;
    private Hair hair;

    public HP getHp() {
        return hp;
    }

    public void setHp(HP hp) {
        this.hp = hp;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public BeanShooter() {
        init();
    }

    public void fight() {
        System.out.println("豌豆射手发射豌豆");
    }

    public void place(int coordinate) {
        System.out.println("豌豆射手被放置在 " + coordinate + " 的位置");
    }

    @Override
    protected void init() {
        System.out.println("豌豆射手被创建");
    }

    @Override
    public void die() {
        System.out.println("豌豆射手死掉了");
    }
}
