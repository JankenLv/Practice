package com.imooc.servlet;

import com.imooc.service.CourseService;
import com.imooc.service.serviceImpl.CourseServiceImpl;
import com.imooc.utils.RegexUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class UserServlet extends HttpServlet {
    private CourseService service = new CourseServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/addUser",request.getServletPath())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (RegexUtil.validateUsername(username) && RegexUtil.validatePassword(password)) {
                request.setAttribute("msg",(service.addUser(username, password)==1)? "成功添加管理员！":"该名称已被使用，不能重复添加！");
                request.getRequestDispatcher("/goTo?page=addUser").forward(request, response);
            } else {
                request.setAttribute("msg", "注册信息有误！");
                request.getRequestDispatcher("/goTo?page=addUser").forward(request, response);
            }
        } else if (Objects.equals("/delUser",request.getServletPath())) {
            String username = request.getParameter("username");
            service.delUser(username);
            response.sendRedirect(request.getContextPath() + "/getAllUsers");

        } else if (Objects.equals("/getAllUsers", request.getServletPath())) {
            request.setAttribute("allUsers",service.getAllUsers());
            request.getRequestDispatcher("/goTo?page=selectUsers").forward(request,response);

        }else if (Objects.equals("/validateUserName", request.getServletPath())) {
            String username = request.getParameter("username");
            String result = service.getUser(username)==null ? "-1" : "1";

            response.setContentType("text/character;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(result);
            writer.flush();
            writer.close();
        }
    }
}
