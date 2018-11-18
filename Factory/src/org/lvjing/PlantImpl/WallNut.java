package org.lvjing.PlantImpl;

import org.lvjing.Plant.Plant;

public class WallNut extends Plant {

    public WallNut() {
        init();
    }

    public void fight() {
        System.out.println("坚果墙阻挡着进攻的敌人");
    }

    public void place(int coordinate) {
        System.out.println("坚果墙被放置在 " + coordinate + " 的位置");
    }

    @Override
    protected void init() {
        System.out.println("坚果墙被创建");
    }

    @Override
    public void die() {
        System.out.println("坚果墙死掉了");
    }

}
