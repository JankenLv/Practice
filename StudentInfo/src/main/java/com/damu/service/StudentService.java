package com.damu.service;

import com.damu.dao.studentDAO;
import com.damu.entity.Course;
import com.damu.entity.Student;
import com.damu.entity.StudentWithCourse;

import java.util.List;

public class StudentService {

    private studentDAO studentDAO;

    private static StudentService ourInstance = new StudentService();

    public static StudentService getInstance() {
        return ourInstance;
    }

    private StudentService() {
        studentDAO = new studentDAO();
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Student addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    public Student modifyStudent(Student student) {
        return studentDAO.modifyStudent(student);
    }

    public int delStudent(int id) {
        return studentDAO.delStudent(id);
    }

    public List<Course> getAllCourses() {
        return studentDAO.getAllCourses();
    }

    public Course getCourseById(int id) {
        return studentDAO.getCourseById(id);
    }

    public Student getStudentAndCourse(int id) {
        return studentDAO.getStudentAndCourse(id);
    }

    public StudentWithCourse getStudentWithCourse(int id) {
        return studentDAO.getStudentWithCourse(id);
    }
}
