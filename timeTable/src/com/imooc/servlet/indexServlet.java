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
public class indexServlet extends HttpServlet {

    private void goTo(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Objects.equals("/index",request.getServletPath())) {
            goTo("addCourse",request,response);
        } else if (Objects.equals("/goTo",request.getServletPath())) {
            String page = request.getParameter("page");
            switch (page) {
                case "showCourse":
                    goTo("showCourse",request,response);
                    break;
                default:
                    goTo("addCourse",request,response);
                    break;
            }
//            goTo("addCourse",request,response);
        }
        /*if (page!=null) {
            goTo("showCourse",request,response);
        } else if (page==null) {
            goTo("addCourse",request,response);
        }*/

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    /*@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/index", request.getServletPath())) {
            goTo("addCourse",request,response);
        } else if (Objects.equals("/showCourse", request.getServletPath())) {
            goTo("showCourse",request,response);
        }
    }*/
}
