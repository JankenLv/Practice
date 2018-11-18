package com.lvjing.db.dao;

import com.lvjing.db.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseDAO {

    private Map<Integer, Course> map = new HashMap<>();

    public void add(Course course) {
        map.put(course.getId(),course);
    }

    public Collection<Course> getAll() {
        return map.values();
    }
}
