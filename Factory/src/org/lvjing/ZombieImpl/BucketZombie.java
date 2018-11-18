package org.lvjing.ZombieImpl;

import org.lvjing.Base.Role;
import org.lvjing.Component.HP;
import org.lvjing.Component.Hair;
import org.lvjing.Zombie.Zombie;

public class BucketZombie extends Role implements Zombie {

    private HP hp;
    private Hair hair;

    @Override
    public String toString() {
        return "BucketZombie{" +
                "生命值：" + hp +
                ", 头发：" + hair +
                '}';
    }

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

    public BucketZombie(){
        init();
    }

    public void fight() {
        System.out.println("铁桶僵尸进攻啦！");
    }

    public void place(int coordinate) {
        System.out.println("铁桶僵尸别放置在 " + coordinate + " 的位置");
    }

    @Override
    protected void init() {
        System.out.println("铁桶僵尸被创建");
    }

    @Override
    public void die() {
        System.out.println("铁桶僵尸死掉了");
    }


}
