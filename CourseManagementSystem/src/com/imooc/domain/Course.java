package com.imooc.domain;

import com.imooc.service.CourseService;
import com.imooc.service.serviceImpl.CourseServiceImpl;

public class Course {
    private String id;
    private String courseName;
    private String courseType;
    private String description;
    private String courseTime;
    private String operator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        CourseService courseService = new CourseServiceImpl();
        int sizeOfId = courseService.getAllCourse().size();
        if (sizeOfId == 0) {
            this.id = String.valueOf(1);
        } else {
            this.id = String.valueOf(sizeOfId + 1);
        }

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        if (courseTime.matches("\\d+")) {
            courseTime = String.valueOf(Float.valueOf(courseTime));
        }
        this.courseTime = courseTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", description='" + description + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
