package net.xdclass.demo.controller;

import net.xdclass.demo.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@PropertySource("classpath:application.properties")
public class UserController {

    @Value("${web.upload-path}")
    private String path;

    @GetMapping("/get_user")
    public Object testJson() {
        User user = new User();
        user.setName(path);
        user.setPwd("12345");
        user.setLoginTime(new Date());
        return user;
    }

    @RequestMapping("/test_properties")
    public Object testProperties() {
        return new User();
    }

    @GetMapping("/api/user/login")
    public Object login(@RequestParam String account) {
        return new User(account, "9527777", new Date());
    }

}
