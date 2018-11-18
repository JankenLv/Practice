package com.damu.servlet;

import com.damu.entity.Student;
import com.damu.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyStudent")
public class modifyStudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = StudentService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer  id = Integer.valueOf(request.getParameter("id"));
            Integer reg_no = Integer.valueOf(request.getParameter("reg_no"));
            String  name = request.getParameter("name");
            String  sex = request.getParameter("sex");
            Integer  age = Integer.valueOf(request.getParameter("age"));
            String  grade = request.getParameter("grade");
            String  major = request.getParameter("major");

            Student student = studentService.modifyStudent(new Student(id, reg_no, name, sex, age, grade, major));
            response.sendRedirect(request.getContextPath() + "/showStudentDetail?id=" + student.getId());
        } catch (NumberFormatException | IOException e) {
            request.getRequestDispatcher("/WEB-INF/views/error/500.jsp");
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
