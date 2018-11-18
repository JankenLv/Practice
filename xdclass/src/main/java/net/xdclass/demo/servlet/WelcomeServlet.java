package net.xdclass.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义servlet
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/4 10:56 </p>
 */
@WebServlet(urlPatterns = {"/api/servlet/welcome"},name = "welcomeServlet")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 直接向页面打印输出
        String username = req.getParameter("username");
        PrintWriter writer = resp.getWriter().append("welcome! My friend: ")
                .append(username);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
