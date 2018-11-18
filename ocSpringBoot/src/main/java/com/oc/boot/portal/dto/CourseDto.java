package com.oc.boot.portal.dto;

import com.oc.boot.portal.bean.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDto {

    private Map<String, List<Course>> map = new HashMap<>();

    public Map<String, List<Course>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Course>> map) {
        this.map = map;
    }
}
