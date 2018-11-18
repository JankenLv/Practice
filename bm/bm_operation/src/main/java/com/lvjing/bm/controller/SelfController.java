package com.lvjing.bm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    //     /main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("book/list.do");
    }

    //      /portal.do
    public void portal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String portal = request.getServletContext().getInitParameter("portal");
        if (!StringUtils.isEmpty(portal)) {
            response.sendRedirect(portal);
        }
    }
}
