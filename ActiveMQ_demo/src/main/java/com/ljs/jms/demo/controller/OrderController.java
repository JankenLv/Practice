package com.ljs.jms.demo.controller;

import com.ljs.jms.demo.service.ProducerService;
import com.ljs.jms.demo.utils.JsonData;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * 功能描述：订单Controller
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/22 0:01 </p>
 */
@RestController
@RequestMapping("api/v1/atMQ")
public class OrderController {

    @Autowired
    private ProducerService producerService;

    /**
     * 功能描述：微信支付接口回调
     * @param msg 支付信息
     * @return java.lang.Object
     */
    @GetMapping("/order")
    public Object order(String msg) {
        // destination是消息发送目的地
        Destination destination = new ActiveMQQueue("order.queue");
        producerService.sendMessage(destination, msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("/common")
    public Object common(String msg) {
        producerService.sendMessage(msg);
        return JsonData.buildSuccess();
    }

    /**
     * 功能描述：发布消息
     * @param msg
     * @return java.lang.Object
     */
    @GetMapping("/topic")
    public Object topic(String msg) {
        producerService.publish(msg);
        return JsonData.buildSuccess();
    }


}
