package com.lvjing.hd.controller;

import com.lvjing.hd.entity.User;
import com.lvjing.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller("authController")
public class AuthController {

    @Autowired
    private UserService userService;

    //    /auth/login.do          /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("USER", user);
                response.sendRedirect("dept/list.do");
            } else {
                response.setContentType("text/html;charset=utf8");
                PrintWriter writer = response.getWriter();
                writer.print("<script type='text/javascript'>alert('密码错误！');window.history.back();</script>");
            }
        } else {
            response.setContentType("text/html;charset=utf8");
            PrintWriter writer = response.getWriter();
            writer.print("<script type='text/javascript'>alert('用户不存在！');window.history.back();</script>");
        }
    }

    //    /auth/toLogin.do          /toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request,response);
    }

    //    /main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getSession().getAttribute("USER")== null ? "toLogin.do" : "dept/list.do");
    }

    //    /logout.do
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user!=null) {
            session.setAttribute("USER",null);
        }
        response.sendRedirect("gotoPortal.do");
    }

    //    /auth/toRegister.do        /toRegister.do
    public void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(request,response);
    }

    //    /auth/register.do         /register.do
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (!username.equals("") && !password.equals("")) {
            User user = userService.getUser(username);
            if (user == null) {
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userService.register(user);
                response.sendRedirect("toLogin.do");
            } else {
                response.setContentType("text/html;charset=utf8");
                PrintWriter writer = response.getWriter();
                writer.print("<script type='text/javascript'>alert('用户名已被使用！');window.history.back();</script>");
            }
        } else {
            response.sendRedirect("toRegister.do");
        }

    }

    //    /gotoPortal.do
    public void gotoPortal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String portalName = request.getServletContext().getInitParameter("portalName");
        if (portalName != null) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("USER");
            if (user != null) {
                response.sendRedirect("/" + portalName + "?USER=" + user.getUsername());
            } else {
                response.sendRedirect("/" + portalName);
            }
        }

    }

}
