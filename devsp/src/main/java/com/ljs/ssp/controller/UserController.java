package com.ljs.ssp.controller;

import com.ljs.ssp.async.AsyncTask;
import com.ljs.ssp.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：测试异步任务
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/12 21:42 </p>
 */
@RestController
@RequestMapping(("/api/v1/task"))
public class UserController {

    @Autowired
    private AsyncTask asyncTask;

    /**
     * 异步执行任务（不获取子线程的结果）
     * 耗时：瞬间（几ms）
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/async_task")
    public JsonData exeTask() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTask.asyncTask1();
        asyncTask.asyncTask2();
        asyncTask.asyncTask3();
        long end = System.currentTimeMillis();

        long totalTime = (end - start);
        System.out.println("主线程任务执行完毕，耗时：" + totalTime);
        return JsonData.buildSuccess(totalTime);
    }

    /**
     * 异步执行任务，并获取所有子任务的返回值
     * 耗时：花费时间最大的子线程的时间 + 一点点的时间
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/async_task_result")
    public JsonData exeTaskResult() throws InterruptedException {
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
        return JsonData.buildSuccess(totalTime);
    }

}
