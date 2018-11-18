package com.oc.boot.portal.service.impl;

import com.oc.boot.portal.bean.Course;
import com.oc.boot.portal.dao.CourseDao;
import com.oc.boot.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseDao courseDao;

    @Override
    @Transactional(readOnly = true)
    public Map<String, List<Course>> getAllCourses() {
        Map<String, List<Course>> map = new HashMap<>();
        map.put("freeCourses",courseDao.selectByFree(1));
        map.put("payCourses",courseDao.selectByFree(0));
        return map;
    }
}
