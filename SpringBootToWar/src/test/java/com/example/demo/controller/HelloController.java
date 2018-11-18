package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/3 22:25 </p>
 */
@Controller
public class HelloController {

    @RequestMapping("/api/v1/hello")
    @ResponseBody
    public Object helloWorld() {
        return "Pack SpringBoot Project To War";
    }

}
