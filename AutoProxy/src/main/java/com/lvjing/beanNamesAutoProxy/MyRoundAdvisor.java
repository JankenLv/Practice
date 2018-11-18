package com.lvjing.beanNamesAutoProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强方法
 */
public class MyRoundAdvisor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("前置增强==========");

        Object proceed = methodInvocation.proceed();

        System.out.println("==========后置增强");

        return proceed;
    }
}
