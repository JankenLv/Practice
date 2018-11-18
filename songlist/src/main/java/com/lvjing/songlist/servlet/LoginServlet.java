package com.lvjing.songlist.servlet;

import com.google.common.base.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/loginPrompt","/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equal("/loginPrompt",request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request,response);
        } else if (Objects.equal("/login", request.getServletPath())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username != null && !(username.equals("")) && username.equals(password)) {
                request.getSession().setAttribute("username", username);
                request.getRequestDispatcher("/WEB-INF/views/biz/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request,response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
        }
    }
}
