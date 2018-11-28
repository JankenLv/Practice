package com.ljs.jms.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 功能描述：p2p消息消费者
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/27 22:48 </p>
 */
@Component
public class OrderConsumer {

    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text) {
        System.out.println("OrderConsumer1接收到的报文为：" + text);
    }

    @JmsListener(destination = "order.queue")
    public void receiveQueue1(String text) {
        System.out.println("OrderConsumer2接收到的报文为：" + text);
    }

}
