package com.sse.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：服务端主动推送技术：Sever-Send-Events
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/12/12 22:24 </p>
 */
@RestController
@RequestMapping("/api/v1/sse")
public class SSEController {

    @GetMapping(value = "/send_data", produces = "text/event-stream;charset=UTF-8")
    public String serverSend() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:xdclass股市行情推送：" + Math.random() + "\n\n";
    }

}
