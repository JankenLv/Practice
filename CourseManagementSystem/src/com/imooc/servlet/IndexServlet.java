package com.imooc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 管理页面跳转的servlet
 */
public class IndexServlet extends HttpServlet {

    private void goTo(String path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") != null) {
            if (!Objects.equals("showCourse", path)) {
                request.getSession().removeAttribute("export");
            }
            request.getRequestDispatcher( "/WEB-INF/views/" + path + ".jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/index",request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
        }
        else if(Objects.equals("/goTo",request.getServletPath())) {
            switch (request.getParameter("page")) {
                case "left":
                    goTo("left",request,response);
                    break;
                case "top":
                    goTo("top",request,response);
                    break;
                case "addCourse":
                    goTo("addCourse",request,response);
                    break;
                case "showCourse":
                    goTo("showCourse",request,response);
                    break;
                case "courseImport":
                    goTo("courseImport",request,response);
                    break;
                case "addUser":
                    goTo("addUser",request,response);
                    break;
                case "selectUsers":
                    goTo("selectUsers",request,response);
                    break;
                case "server":
                    goTo("server",request,response);
                    break;
                case "warning":
                    goTo("warning",request,response);
                    break;
            }
        }
    }

}
