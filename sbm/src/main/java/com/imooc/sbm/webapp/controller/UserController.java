package com.imooc.sbm.webapp.controller;

import com.imooc.sbm.webapp.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/toLogin.html")
    public String login(Map<String, Object> map) {
        map.put("user", new User());
        return "login";
    }

    @RequestMapping("/login.html")
    public String login(User user, Map<String, Object> map) {
        if (!StringUtils.isEmpty(user.getName()) && !StringUtils.isEmpty(user.getPassword()) && user.getName().equals("小明") && user.getPassword().equals("123456")) {
            user.setName("小红");
        }
        map.put("user",user);
        return "user_info";
    }
}
