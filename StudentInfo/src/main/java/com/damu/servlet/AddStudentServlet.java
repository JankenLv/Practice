package com.damu.servlet;

import com.damu.entity.Student;
import com.damu.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = StudentService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer reg_no = null;
        String name = null;
        String sex = null;
        Integer age = null;
        String grade = null;
        String major = null;
        try {
            reg_no = Integer.valueOf(request.getParameter("reg_no"));
            name = request.getParameter("name");
            sex = request.getParameter("sex");
            age = Integer.valueOf(request.getParameter("age"));
            grade = request.getParameter("grade");
            major = request.getParameter("major");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("学生信息有误。");
        }

        Student student = studentService.addStudent(new Student(reg_no, name, sex, age, grade, major));
        response.sendRedirect(request.getContextPath() + "/showStudentDetail?id=" + student.getId());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
