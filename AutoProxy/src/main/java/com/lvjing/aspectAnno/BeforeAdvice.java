package com.lvjing.aspectAnno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class BeforeAdvice {

    @Pointcut(value = "execution(* com.lvjing.aspectAnno.MemberDao.addMember(..))")
    private void addMember() {

    }

    @Pointcut(value = "execution(* com.lvjing.aspectAnno.MemberDao.delMember(..))")
    private void delMember() {

    }

    @Pointcut(value = "execution(* com.lvjing.aspectAnno.MemberDao.updateMember(..))")
    private void updateMember() {

    }

    @Pointcut(value = "execution(* com.lvjing.aspectAnno.MemberDao.findMember(..))")
    private void findMember() {

    }




    @Before(value = "addMember()")
    public void doSomething(JoinPoint joinPoint) {
        System.out.println("advice before ========== " + joinPoint);
    }

    @AfterReturning(value = "delMember()",returning = "result")
    public void doAfter(Object result) {
        System.out.println(" ========== advice after");
        System.out.println("user: " + result);
    }

    @Around(value = "updateMember()")
    public Object doRound(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("advice before ========== ");

        Object proceed = joinPoint.proceed();

        System.out.println(" ========== advice after");

        return proceed;
    }

    @AfterThrowing(value = "findMember()")
    public void doAfterException() {
        System.out.println("find a new exception!");
    }

    @After(value = "delMember()")
    public void doAfterWhatever() {
        System.out.println("method was finished");
    }

}
