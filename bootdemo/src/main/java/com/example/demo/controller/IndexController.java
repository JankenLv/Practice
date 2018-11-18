package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name","小猪佩奇");
        return "auth";
    }

    /*@RequestMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response) throws IOException {
        if (user.getName().equals("小猪乔治") && user.getPassword().equals("123456")) {
            user.setPassword("7");
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("name: " + user.getName() + " password: " + user.getPassword());
    }*/

    @RequestMapping(value = "/login")
    @ResponseBody
    public User getUser(@RequestBody User user) {
        user.setPassword(user.getPassword() + "7");
        return user;
    }
}
