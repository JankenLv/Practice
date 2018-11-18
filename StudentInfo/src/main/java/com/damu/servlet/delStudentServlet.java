package com.damu.servlet;

import com.damu.entity.Student;
import com.damu.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delStudent")
public class delStudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = StudentService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            if (studentService.delStudent(id)>0) {
                response.sendRedirect(request.getContextPath() + "/getStudents");
            }else {
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp");
            }
//            Student student = studentService.getStudentById(id);
//            request.setAttribute("student",student);
//            request.getRequestDispatcher("/WEB-INF/views/biz/studentDetail.jsp").forward(request,response);
        } catch (Exception e) {
            request.getRequestDispatcher("/WEB-INF/views/error/500.jsp");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
