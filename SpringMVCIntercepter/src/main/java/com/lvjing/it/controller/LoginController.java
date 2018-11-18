package com.lvjing.it.controller;

import com.lvjing.it.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login",method = POST)
    public String login(User user, HttpSession session) {
        if (!StringUtils.isEmpty(user.getAccount()) && !StringUtils.isEmpty(user.getPassword()) && user.getAccount().equals("小明") && user.getPassword().equals("123456")) {
            session.setAttribute("session_user", user);
            return "redirect:/emp/list";
        } else {
            return "redirect:/auth/toLogin";
        }
    }


}
