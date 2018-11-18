package com.lvjing.springinitialize.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class MyController {

    @Value("${app.author-name}")
    private String authorName;
    @Value("${app.create-date}")
    private String createDate;
    @Value("${app.environment}")
    private String environment;

    @RequestMapping("/index")
    @ResponseBody
    public String welcome() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "创作者：" + authorName + " 创建日期：" + format.parse(createDate) + " 工作环境：" + environment;
    }
}
