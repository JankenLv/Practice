package com.lvjing.domain;

public class Goods {
    private String id;
    private String name;
    private String price;
    private String desp;

    public Goods() {

    };

    public Goods(String id,String name,String price,String desp){
        this.id = id;
        this.name = name;
        this.price = price;
        this.desp = desp;
    };

    public void display() {
        System.out.println(Goods.class.toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", desp='" + desp + '\'' +
                '}';
    }
}
