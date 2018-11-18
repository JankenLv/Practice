package com.ljs.ssp.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述：定时任务业务类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/11 22:24 </p>
 */
@Component
public class TestTask {

    // 定时执行
    @Scheduled(fixedRate = 3000)
    public void showTime() {
        System.out.println("定时器打印当前时间：" + new Date());
    }

    // cron表达式
    @Scheduled(cron = "1 * * * * *")
    public void showTime1() {
        System.out.println("定时器打印当前时间：" + new Date());
    }

    // 方法执行完后，定时执行
    @Scheduled(fixedDelay = 2000)
    public void showTime2() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("定时器打印当前时间：" + new Date());
    }

    // 定时器常用方法：把定时的时间写在配置文件中，使用注解把值注入方法中
    @Scheduled(fixedRateString = "3000")
    public void showTime3() {
        System.out.println("定时器打印当前时间：" + new Date());
    }

}
