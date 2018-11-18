package com.lvjing.cms;

public class TestClient implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" : " + Thread.currentThread().getId() +
                " : " + testThreadLocal.getDate() + "\n" );
    }

    private TestThreadLocal testThreadLocal;

    public TestClient(TestThreadLocal testThreadLocal) {
        this.testThreadLocal = testThreadLocal;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() +" : " + Thread.currentThread().getId() +
        " : " + testThreadLocal.getDate() + "\n" );
    }

}
