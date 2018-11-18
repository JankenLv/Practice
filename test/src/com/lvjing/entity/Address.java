package com.lvjing.entity;

public class Address {
    private String id;
    private String name;
    private String detail;
    private String phone;

    private Address(){};

    public Address(String id, String name, String detail, String phone){
        this.id= id;
        this.name = name;
        this.detail = detail;
        this.phone = phone;
    }


    public void display() {
        System.out.println("这是一个地址");
    }

    private void info() {
        System.out.println("我是私有方法");
    }

    private void equalsAddress(String name) {
        System.out.println(this.name.equalsIgnoreCase(name)?"相等":"不相等");
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
