package com.lvjing.hd.controller;

import com.lvjing.hd.entity.Category;
import com.lvjing.hd.entity.Department;
import com.lvjing.hd.entity.User;
import com.lvjing.hd.service.CategoryService;
import com.lvjing.hd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller("portalController")
public class PortalController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CategoryService categoryService;

    //    /portal/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        List<Category> subList = categoryService.getAll();
        request.setAttribute("SUBLIST",subList);
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("/WEB-INF/views/biz/hospital_detail.jsp").forward(request,response);
    }

    //    /portal/toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceName = request.getServletContext().getInitParameter("serviceName");
        String loginOperate = request.getServletContext().getInitParameter("loginOperate");
        if (serviceName != null) {
            response.sendRedirect("/" + serviceName + "/" + loginOperate );
        }
    }

    //    /portal/toLogout.do
    public void toLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceName = request.getServletContext().getInitParameter("serviceName");
        String logoutOperate = request.getServletContext().getInitParameter("logoutOperate");
        if (serviceName != null) {
            response.sendRedirect("/" + serviceName + "/" + logoutOperate );
        }
    }

    //    /portal/toRegister.do
    public void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceName = request.getServletContext().getInitParameter("serviceName");
        String registerOperate = request.getServletContext().getInitParameter("registerOperate");
        if (serviceName != null) {
            response.sendRedirect("/" + serviceName + "/" + registerOperate );
        }
    }

    //    /portal/toService.do
    public void toService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceName = request.getServletContext().getInitParameter("serviceName");
        if (serviceName != null) {
            response.sendRedirect("/" + serviceName);
        }
    }

    //    /main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("USER");
        HttpSession session = request.getSession();
        session.setAttribute("USER", username);
        response.sendRedirect("list.do");
    }
}
