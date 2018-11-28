package com.ljs.jms.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 功能描述：消息订阅者
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/28 23:09 </p>
 */
@Component
public class TopicSub {

    @JmsListener(destination = "video.topic", containerFactory="jmsListenerContainerTopic")
    public void video(String text) {
        System.out.println("video.topic 消费者1收到消息：" + text);
    }

    @JmsListener(destination = "video.topic", containerFactory="jmsListenerContainerTopic")
    public void video1(String text) {
        System.out.println("video.topic 消费者2收到消息：" + text);
    }

    @JmsListener(destination = "video.topic")
    public void video2(String text) {
        System.out.println("video.topic 消费者3收到消息：" + text);
    }

}
