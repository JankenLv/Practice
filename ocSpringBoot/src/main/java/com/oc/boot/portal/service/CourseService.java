package com.oc.boot.portal.service;

import com.oc.boot.portal.bean.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    Map<String, List<Course>> getAllCourses();
}
