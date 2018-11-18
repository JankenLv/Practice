package com.damu.entity;

import java.util.Date;

public class Course {

    private Integer id;
    private String courseID;
    private String majorName;
    private String courseName;
    private Date   courseTime;
    private String courseTeacher;

    public Course() {

    }

    public Course(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseID='" + courseID + '\'' +
                ", majorName='" + majorName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTime=" + courseTime +
                ", courseTeacher='" + courseTeacher + '\'' +
                '}';
    }


}
