package rocketmq.demo.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocketmq.demo.jms.MsgProducer;
import rocketmq.demo.utils.JsonData;

import java.io.UnsupportedEncodingException;

/**
 * 功能描述：微信支付回调接口
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/12/8 22:43 </p>
 */
@RestController
@RequestMapping("/api/v1/rocketmq")
public class OrderController {

    @Autowired
    private MsgProducer msgProducer;

    /**
     * 功能描述：微信支付回调接口
     * @param msg 支付信息
     * @param tag  消息二级分类
     * @return java.lang.Object
     */
    @GetMapping("order")
    public Object order(String msg, String tag) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        /*
         * 创建一个消息实例，包含topic、tag和消息体
         */
        Message message = new Message("testTopic", tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

        SendResult result = msgProducer.getProducer().send(message);

        System.out.println("发送响应：MsgId：" + result.getMsgId() + "，发送状态：" + result.getSendStatus());

        return JsonData.buildSuccess();
    }

}
