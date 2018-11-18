package com.lvjing.mvc.controller;

import com.lvjing.mvc.entity.Good;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/*
 *基于注解方式实现SpringMVC
 */
@Controller
public class AnnotationHandler {

    /**
     * 业务方法：ModelAndView完成数据的传递，视图的解析
     * @return 模型与视图
     */
    @RequestMapping("/modelAndViewTest")
    public ModelAndView modelAndViewTest() {
        // 创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 填充模型数据
        modelAndView.addObject("user","金盛");
        // 设置逻辑视图
        modelAndView.setViewName("home");
        return modelAndView;
    }


    /**
     * 业务方法：Model传值，String进行视图解析
     * @param model 数据模型
     */
    @RequestMapping("/ModelTest")
    public String ModelTest(Model model) {
        // 填充模型数据
        model.addAttribute("user","小明");
        // 设置逻辑视图
        return "home";
    }


    /**
     * 业务方法：Map传值，String进行解析
     * @param map 充当数据模型角色的Map
     */
    @RequestMapping("/MapTest")
    public String MapTest(Map<String, String> map) {
        // 填充数据模型
        map.put("user","小红");
        // 设置逻辑视图
        return "home";
    }


    /**
     * 业务方法：测试自动映射实体类！
     */
    @RequestMapping("/good")
    public String good(Good good) {
        Map<String,Object> map = new HashMap<>();
        System.out.println(good);
        // 填充数据模型
        map.put("good",good);
        return "good";
    }
}
