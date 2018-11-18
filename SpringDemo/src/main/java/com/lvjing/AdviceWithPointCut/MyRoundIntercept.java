package com.lvjing.AdviceWithPointCut;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyRoundIntercept implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("增强前置方法");
        Object proceed = methodInvocation.proceed();
        System.out.println("增强后置方法");
        return proceed;
    }
}
