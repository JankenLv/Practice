package com.lvjing.aspectXML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdviceMethod {

    // 前置通知
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(" ============= advice before " + joinPoint);
    }

    // 后置通知
    public void afterAdvice(Object result) {
        System.out.println(" ============= advice after " + result);
    }

    // 环绕通知
    public Object roundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(" ============= advice round after");

        Object proceed = joinPoint.proceed();

        System.out.println("advice round after ============= ");

        return proceed;
    }

    // 异常抛出通知
    public void afterThrowing(Throwable e) {
        System.out.println(" ============= advice after " + e.getMessage());
    }

    // 最终通知
    public void finalAdvice() {
        System.out.println("=== method finished ===");
    }

}
