package com.ljs.jms.demo.service.impl;

import com.ljs.jms.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 功能描述：消息生产者
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/21 23:51 </p>
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;// 用来发送消息到broker的对象


    //============ 点对点模式 =============

    @Autowired
    private Queue queue;// 默认的消息队列

    @Override
    public void sendMessage(Destination destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    @Override
    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(this.queue,message);
    }



    //============ 发布订阅模式 =============

    @Autowired
    private Topic topic;

    @Override
    public void publish(String msg) {
        jmsTemplate.convertAndSend(this.topic, msg);
    }
}
