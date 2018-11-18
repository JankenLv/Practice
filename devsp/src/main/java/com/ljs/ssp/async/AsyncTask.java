package com.ljs.ssp.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：异步执行业务类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/12 21:24 </p>
 */
@Component
@Async
public class AsyncTask {

    public void asyncTask1() throws InterruptedException {
        long start = System.currentTimeMillis();
//        Thread.sleep(1000L);
        TimeUnit.MILLISECONDS.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1执行完毕，耗时：" + (end - start));
    }

    public void asyncTask2() throws InterruptedException {
        long start = System.currentTimeMillis();
//        Thread.sleep(2000L);
        TimeUnit.MILLISECONDS.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("任务2执行完毕，耗时：" + (end - start));
    }

    public void asyncTask3() throws InterruptedException {
        long start = System.currentTimeMillis();
//        Thread.sleep(3000L);
        TimeUnit.MILLISECONDS.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("任务3执行完毕，耗时：" + (end - start));
    }

    public Future<String> asyncTask4() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000L);
//        TimeUnit.MILLISECONDS.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务4执行完毕，耗时：" + (end - start));
        return new AsyncResult<>("任务4执行完毕");
    }

    public Future<String> asyncTask5() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(2000L);
//        TimeUnit.MILLISECONDS.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务5执行完毕，耗时：" + (end - start));
        return new AsyncResult<>("任务5执行完毕");
    }

    public Future<String> asyncTask6() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000L);
//        TimeUnit.MILLISECONDS.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务6执行完毕，耗时：" + (end - start));
        return new AsyncResult<>("任务6执行完毕");
    }



}
