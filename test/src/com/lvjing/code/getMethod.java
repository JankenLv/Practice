package com.lvjing.code;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class getMethod {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.lvjing.entity.Address");
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object o = constructor.newInstance();

        Method display = aClass.getMethod("display");
        display.invoke(o);

        Method info = aClass.getDeclaredMethod("info");
        info.setAccessible(true);
        info.invoke(o);

        Constructor<?> c1 = aClass.getConstructor(String.class, String.class, String.class, String.class);
        Object mike = c1.newInstance("1", "mike", "0756", "110");
        System.out.println(mike);

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"ben");

        Method equalsAddress = aClass.getDeclaredMethod("equalsAddress",String.class);
        equalsAddress.setAccessible(true);
        equalsAddress.invoke(o,"ben");
    }
}
