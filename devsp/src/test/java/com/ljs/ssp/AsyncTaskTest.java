package com.ljs.ssp;

import com.ljs.ssp.async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * 功能描述：异步业务测试类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/12 21:28 </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    /**
     * 测试同步执行(把Async相关注解去掉)
     */
    @Test
    public void testSynchro() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTask.asyncTask1();
        asyncTask.asyncTask2();
        asyncTask.asyncTask3();
        long end = System.currentTimeMillis();

        System.out.println("同步执行任务完成，耗时：" + (end - start));
    }

    /**
     * 测试异步执行
     */
    @Test
    public void testAsync() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTask.asyncTask1();
        asyncTask.asyncTask2();
        asyncTask.asyncTask3();
        long end = System.currentTimeMillis();

        Thread.sleep(6000);

        System.out.println("异步执行任务完成，耗时：" + (end - start));
    }

    /**
     * 测试异步执行，获取返回的结果
     */
    @Test
    public void testAsyncResult() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> task4 = asyncTask.asyncTask4();
        Future<String> task5 = asyncTask.asyncTask5();
        Future<String> task6 = asyncTask.asyncTask6();

        // 检查所有子任务是否都执行完毕
        for (;;) {
            if (task4.isDone() && task5.isDone() && task6.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        long totalTime = (end - start);
        System.out.println("主线程任务执行完毕，耗时：" + totalTime);
    }

}
