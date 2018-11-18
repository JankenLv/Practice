package com.damu.test;

import com.damu.entity.Course;
import com.damu.entity.Student;
import com.damu.entity.StudentWithCourse;
import com.damu.service.StudentService;
import com.damu.util.JDBCUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class dbTest {

    private StudentService studentService;
    private Student student;
    private Course course;
    private StudentWithCourse studentWithCourse;

    @Before
    public void initTest() {
        studentService = StudentService.getInstance();
        JDBCUtil.initSqlSessionFactory();
    }

    @Ignore
    public void testDemo1() {
        List<Course> courses = studentService.getAllCourses();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Ignore
    public void testDemo2() {
        Course course = studentService.getCourseById(2);
        System.out.println(course);
    }

    @Ignore
    public void testDemo3() {
        Course course = studentService.getCourseById(2);
        System.out.println(course);
    }

    @Ignore
    public void testDemo4() {
        student = studentService.getStudentAndCourse(20);
        System.out.println(student);
    }

    @Test
    public void testDemo5() {
        studentWithCourse = studentService.getStudentWithCourse(20);
        System.out.println(studentWithCourse);
    }

}
