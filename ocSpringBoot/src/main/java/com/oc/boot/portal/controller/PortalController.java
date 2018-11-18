package com.oc.boot.portal.controller;

import com.oc.boot.portal.service.AuthUserService;
import com.oc.boot.portal.service.ConstsClassifyService;
import com.oc.boot.portal.service.ConstsSiteCarouselService;
import com.oc.boot.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 加载首页
 */
@Controller
@RequestMapping
public class PortalController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ConstsSiteCarouselService constsSiteCarouselService;

    @Autowired
    private ConstsClassifyService constsClassifyService;

    @Autowired
    private AuthUserService authUserService;

    @RequestMapping("/index")
    public String course(Map<String, Object> map) {
        //加载课程
        map.put("courses",courseService.getAllCourses());
        // 加载轮播
        map.put("carousel",constsSiteCarouselService.getAll());
        // 加载分类
        map.put("classify",constsClassifyService.getClassify());
        // 加载讲师
        map.put("teacher",authUserService.getAll());
        return "index";
    }

}
