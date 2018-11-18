package com.imooc.utils;

import com.imooc.domain.Course;

import javax.servlet.http.HttpServletRequest;

public class CourseUtil {
    private CourseUtil(){};

    public static Course pack(HttpServletRequest request) {
        Course course = new Course();
        course.setId(request.getParameter("courseId"));
        course.setCourseName(request.getParameter("courseName"));
        course.setCourseType(request.getParameter("courseType"));
        course.setDescription(request.getParameter("description"));
        course.setCourseTime(request.getParameter("courseTime"));
        course.setOperator(request.getParameter("operator"));
        return course;
    }

}
