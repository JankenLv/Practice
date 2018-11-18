package com.lvjing.rf.controller;

import com.lvjing.rf.dao.CourseDAO;
import com.lvjing.rf.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @RequestMapping(value = "/list", method = GET)
    public ModelAndView list() {
        Collection<Course> list = courseDAO.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Courses",list);
        modelAndView.setViewName("course");
        return modelAndView;
    }

    @RequestMapping(value = "/addCourse",method = POST)
    public String addCourse(Course course) {
        courseDAO.add(course.getId(),course);
        return "redirect:/list";
    }

    @RequestMapping(value = "/removeCourse/{id}",method = DELETE)
    public String removeCourse(@PathVariable(value = "id") Integer id) {
        courseDAO.delete(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/toEditCourse/{id}",method = GET)
    public ModelAndView toEditCourse(@PathVariable(value = "id") Integer id) {
        Course dao = courseDAO.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Course",dao);
        modelAndView.setViewName("edit_course");
        return modelAndView;
    }

    @RequestMapping(value = "/editCourse",method = PUT)
    public String editCourse(Course course) {
        courseDAO.update(course.getId(),course);
        return "redirect:/list";
    }

    @RequestMapping(value = "/getById/{id}",method = GET)
    public ModelAndView getCourseById(@PathVariable(value = "id") Integer id) {
        Course course = courseDAO.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Course",course);
        modelAndView.setViewName("add_course");
        return modelAndView;
    }
}
