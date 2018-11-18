package org.lvjing.Component;

/**
 * 发型及颜色
 */
public class Hair {

    private Enum hairstyle;

    private Enum hairColor;

    public Enum getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(Enum hairstyle) {
        this.hairstyle = hairstyle;
    }

    public Enum getHairColor() {
        return hairColor;
    }

    public void setHairColor(Enum hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return "Hair{" +
                "发型=" + hairstyle +
                ", 发色=" + hairColor +
                '}';
    }
}
