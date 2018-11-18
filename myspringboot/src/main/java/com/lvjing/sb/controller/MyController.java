package com.lvjing.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/index")
    @ResponseBody
    public String hello() {
        return "Hello World! <===> Welcome to Spring Boot!";
    }
}
