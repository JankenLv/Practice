package com.damu.entity;

public class Student {
    private Integer id;
    private Integer reg_no;
    private String name;
    private String sex;
    private Integer age;
    private String grade;
    private String major;
    private Course course;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", reg_no=" + reg_no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", course=" + course +
                '}';
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student(){};

    public Student(Integer id) {
        this.id = id;
    }

    public Student(String major) {
        this.major = major;
    }

    public Student(Integer reg_no, String name, String sex, Integer age, String grade, String major) {
        this.reg_no = reg_no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
        this.major = major;
    }

    public Student(Integer id, Integer reg_no, String name, String sex, Integer age, String grade, String major) {
        this.id = id;
        this.reg_no = reg_no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
        this.major = major;
    }

    public Integer getId() {
        return id;
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
}
