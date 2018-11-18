package org.lvjing.Component;

/**
 * 生命值
 */
public class HP {

    private int hp;

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "HP{" + hp +
                '}';
    }
}
