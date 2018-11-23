package com.ljs.jms.demo.service.impl;

import com.ljs.jms.demo.service.ProducerService;
import javax.jms.Destination;
import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * 功能描述：TODO
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/21 23:51 </p>
 */
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;// 用来发送消息到broker的对象

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
}
