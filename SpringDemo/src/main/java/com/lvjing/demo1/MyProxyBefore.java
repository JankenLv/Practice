package com.lvjing.demo1;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyProxyBefore implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("========== advice before =========");
    }
}
