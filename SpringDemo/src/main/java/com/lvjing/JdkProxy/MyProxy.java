package com.lvjing.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {

    private FoodDao foodDao;

    public MyProxy(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public MyProxy() {
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(FoodDao.class.getClassLoader(), new Class[]{FoodDao.class}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("addFood".equals(method.getName())) {
            System.out.println("========= check authority ========");
            return method.invoke(foodDao,args);
        }
        return method.invoke(foodDao,args);
    }
}
