package com.ljs.jms.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms  // 开启支持消息服务(jms)
public class DemoApplication {

    @Bean   // 交个Spring进行管理，方便后续注入
    public Queue queue() {
        return new ActiveMQQueue("common.queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
