package com.lvjing.rf.dao;

import com.lvjing.rf.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseDAO {
    private Map<Integer, Course> courses = new HashMap<>();

    public void add(Integer id, Course course) {
        courses.put(id,course);
    }

    public void delete(Integer id) {
        courses.remove(id);
    }

    public void update(Integer id, Course course) {
        courses.put(id,course);
    }

    public Course getById(Integer id) {
        return courses.get(id);
    }

    public Collection<Course> getAll() {
        return courses.values();
    }
}
