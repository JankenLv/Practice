package com.imooc.servlet;

import com.imooc.util.JDBCUtil;
import com.imooc.util.RegexUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class addCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        String courseType = request.getParameter("courseType");
        String description = request.getParameter("description");

        if (RegexUtil.validateContent(courseName,courseType,description)) {
            Connection conn = null;
            PreparedStatement pstmt = null;

            String sql = "INSERT INTO imooc.courses(name,category,desp,createTime)VALUE(?,?,?,CURDATE())";

            try {
                conn = JDBCUtil.getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,courseName);
                pstmt.setString(2,courseType);
                pstmt.setString(3,description);
                if (pstmt.executeUpdate() > 0) {
                    response.sendRedirect(request.getContextPath() + "/showCourse");
                } else {
                    request.setAttribute("msg","课程添加失败！");
                    request.getRequestDispatcher("/goTo?page=addCourse").forward(request,response);
//                    System.out.println("课程添加失败！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtil.releaseResource(conn,pstmt);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
