package com.lvjing.JdkProxy;

import org.junit.Test;

public class domain {

    @Test
    public void demo1() {

        FoodDao foodDao = new FoodDaoImpl();

//        ProductDao proxy = (ProductDao) new MyProxy(foodDao).createProxy();
//        ProductDao proxy = (ProductDao) new MyProxy().createProxy();
        FoodDao proxy = (FoodDao) new MyProxy(foodDao).createProxy();
        proxy.addFood();
        proxy.updateFood();
        proxy.delFood();
        proxy.findFood();

    }

}
