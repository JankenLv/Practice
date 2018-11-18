package com.damu.entity;

import java.util.Date;

public class StudentWithCourse {

    private Integer id;
    private Integer reg_no;
    private String name;
    private String sex;
    private Integer age;
    private String grade;
    private String major;
    private String courseName;
    private Date courseTime;
    private String courseTeacher;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudentWithCourse{" +
                "id=" + id +
                ", reg_no=" + reg_no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTime=" + courseTime +
                ", courseTeacher='" + courseTeacher + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReg_no() {
        return reg_no;
    }

    public void setReg_no(Integer reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
}
