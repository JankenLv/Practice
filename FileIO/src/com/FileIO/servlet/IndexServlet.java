package com.FileIO.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理页面跳转的servlet
 */
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page != null) {
            switch (page) {
                case "ImportExcel":
                    request.getRequestDispatcher("/WEB-INF/jsp/importExcel.jsp").forward(request,response);
                    break;
                case "ExportExcel":
                    request.getRequestDispatcher("/WEB-INF/jsp/exportExcel.jsp").forward(request,response);
                    break;
                case "ImportWord":
                    request.getRequestDispatcher("/WEB-INF/jsp/importWord.jsp").forward(request,response);
                    break;
                case "ExportWord":
                    request.getRequestDispatcher("/WEB-INF/jsp/exportWord.jsp").forward(request,response);
                    break;
                default:
                    break;
            }
        } else {
            // 进入默认页面：
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
