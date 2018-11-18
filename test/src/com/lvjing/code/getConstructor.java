package com.lvjing.code;

import com.lvjing.domain.Goods;

import java.lang.reflect.Constructor;

public class getConstructor {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.lvjing.domain.Goods");
        Constructor<?> aConstructor= aClass.getConstructor();
        Goods aInstance = (Goods) aConstructor.newInstance();
        aInstance.display();


        Class<?> bClass = Class.forName("com.lvjing.domain.Goods");
        Constructor<?> bConstructor = bClass.getConstructor(String.class, String.class, String.class, String.class);
        Object bInstance = bConstructor.newInstance("1","phone","1500","very cheap");
//        Object bInstance = bConstructor.newInstance();
        System.out.println(bInstance.toString());

    }
}
