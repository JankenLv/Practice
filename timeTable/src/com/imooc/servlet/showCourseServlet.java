package com.imooc.servlet;

import com.imooc.dao.Course;
import com.imooc.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class showCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        String sql = "SELECT * FROM imooc.courses";

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                Course course = new Course();
                course.setId(res.getInt("id"));
                course.setCourseName(res.getString("name"));
                course.setCourseType(res.getString("category"));
                course.setDescription(res.getString("desp"));
                course.setDate(res.getDate("createTime"));

                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.releaseResource(conn,pstmt,res);
        }

        request.setAttribute("courses",courses);
        request.getRequestDispatcher("/goTo?page=showCourse").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
