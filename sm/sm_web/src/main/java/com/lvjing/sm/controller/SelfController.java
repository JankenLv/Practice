package com.lvjing.sm.controller;

import com.lvjing.sm.entity.Staff;
import com.lvjing.sm.service.SelfService;
import com.lvjing.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;

    @Autowired
    private StaffService staffService;

    //    /toLogin.do

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
    }

    //   /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Staff staff = selfService.login(account, password);
        if (staff==null) {
            response.sendRedirect("toLogin.do");
        }

        HttpSession session = request.getSession();
        session.setAttribute("USER",staff);
        response.sendRedirect("main.do");
    }

    //   /main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
    }

    //   /logout.do
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER",null);
        response.sendRedirect("toLogin.do");
    }

    //   /self/info.do
    public void info(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/pages/user_info.jsp").forward(request,response);
    }

    //   /self/toChangePassword.do
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/pages/change_password.jsp").forward(request,response);
    }

    //   /self/changePassword.do
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String newPassword = request.getParameter("newPassword");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Staff user = (Staff) session.getAttribute("USER");
        if (user.getPassword().equals(password)) {
            selfService.changePassword(user.getId(), newPassword);
//            response.sendRedirect("logout.do");
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"logout.do\";</script>");
        } else {
            response.sendRedirect("toChangePassword.do");
        }
    }
}
