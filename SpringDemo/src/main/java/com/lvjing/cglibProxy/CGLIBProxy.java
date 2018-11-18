package com.lvjing.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {

    private CarDao carDao;

    public CGLIBProxy(CarDao carDao) {
        this.carDao = carDao;
    }

    public Object createProxy() {
        // 1.创建核心类
        Enhancer enhancer = new Enhancer();

        // 2.设置代理类的父类
        enhancer.setSuperclass(carDao.getClass());

        // 3.设置回调
        enhancer.setCallback(this);

        // 4.创建代理类
        Object proxy = enhancer.create();

        return proxy;
    }


    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("addCar".equals(method.getName())) {
            System.out.println("intercept success!");
            return methodProxy.invokeSuper(proxy,args);
        }
        return methodProxy.invokeSuper(proxy,args);
    }
}
