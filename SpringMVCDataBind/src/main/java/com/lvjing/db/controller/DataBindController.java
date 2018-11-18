package com.lvjing.db.controller;

import com.lvjing.db.dao.CourseDAO;
import com.lvjing.db.entity.Course;
import com.lvjing.db.entity.CourseList;
import com.lvjing.db.entity.CourseMap;
import com.lvjing.db.entity.CourseSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试SpringMVC数据绑定
 */
@Controller
public class DataBindController {

    @Autowired
    private CourseDAO courseDAO;

    @RequestMapping(value = "/baseType")
    @ResponseBody
    public String baseType(@RequestParam(value = "id") int id) {
        return "id: " + id;
    }

    @RequestMapping(value = "/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "id") Integer id) {
        return "id: " + id;
    }

    @RequestMapping(value = "/arrayType",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String arrayType(String[] name) {
        StringBuilder str = new StringBuilder();
        for (String s : name) {
            str.append(s).append(" ");
        }
        return "array: " + str;
    }

    @RequestMapping(value = "/pojoType")
    public ModelAndView pojoType(Course course) {
        courseDAO.add(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses",courseDAO.getAll());
        modelAndView.setViewName("course");
        return modelAndView;
    }

    @RequestMapping(value = "/listType")
    public ModelAndView listType(CourseList courseList) {
        for (Course course : courseList.getCourses()) {
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses",courseDAO.getAll());
        modelAndView.setViewName("course");
        return modelAndView;
    }

    @RequestMapping(value = "/mapType")
    public ModelAndView mapType(CourseMap courseMap) {
        for (String key : courseMap.getCourses().keySet()) {
            courseDAO.add(courseMap.getCourses().get(key));
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses",courseDAO.getAll());
        modelAndView.setViewName("course");
        return modelAndView;
    }

    @RequestMapping(value = "/setType")
    public ModelAndView setType(CourseSet courseSet) {
        for (Course course : courseSet.getCourses()) {
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses",courseDAO.getAll());
        modelAndView.setViewName("course");
        return modelAndView;
    }

    @RequestMapping(value = "/jsonType")
    @ResponseBody
    public Course jsonType(@RequestBody Course course) {
        course.setPrice(course.getPrice() + 150);
        return course;
    }

}
