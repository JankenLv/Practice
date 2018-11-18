package com.lvjing.JdkProxy;

public class FoodDaoImpl implements FoodDao {

    public void addFood() {
        System.out.println("add new food");
    }

    public void updateFood() {
        System.out.println("update food");
    }

    public void delFood() {
        System.out.println("delete food");
    }

    public void findFood() {
        System.out.println("query food");
    }
}
