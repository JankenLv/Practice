package com.lvjing.cms;

public class domain {

    public static void main(String[] args) {
        TestThreadLocal testThreadLocal = new TestThreadLocal();

        TestClient testClient1 = new TestClient(testThreadLocal);
        TestClient testClient2 = new TestClient(testThreadLocal);
        TestClient testClient3 = new TestClient(testThreadLocal);

        /*testClient1.execute();
        testClient2.execute();
        testClient3.execute();*/

        Thread thread1 = new Thread(testClient1);
        Thread thread2 = new Thread(testClient2);
        Thread thread3 = new Thread(testClient3);

        thread1.start();
        thread2.start();
        thread3.start();

        /*thread1.run();
        thread2.run();
        thread3.run();*/


    }

}
