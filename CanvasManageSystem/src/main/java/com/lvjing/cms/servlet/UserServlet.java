package com.lvjing.cms.servlet;

import com.lvjing.cms.entity.User;
import com.lvjing.cms.service.UserService;
import com.lvjing.cms.util.RegexUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;

/**
 * 用户注册、登录的servlet
 */
@WebServlet(urlPatterns = {"/loginPrompt.do","/login.do","/registerPrompt.do","/register.do","/logout.do"})
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = UserService.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/loginPrompt.do",request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request,response);
        } else if (Objects.equals("/login.do",request.getServletPath())) {
            // 用户登录
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (RegexUtil.validateUsername(username) && RegexUtil.validatePassword(password)) {
                User user = userService.findUser(new User(username));
                if (user!=null) {
                    if (user.getName().equals(username)&& user.getPassword()==Integer.parseInt(password)) {
                        // 登录成功,跳转到后台管理页面
                        request.getSession().setAttribute("username", username);
                        response.sendRedirect(request.getContextPath()+"/manageCanvas.do");
                    } else {
                        // 用户密码错误
                        String msg = "密码错误。";
                        response.setContentType("text/html;charset=utf8");
                        PrintWriter writer = response.getWriter();
                        writer.write("<script type='text/javascript'>alert('" + msg + "');window.history.back();</script>");
                    }
                }else {
                    // 用户不存在
                    String msg = "用户名不存在。";
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter writer = response.getWriter();
                    writer.write("<script type='text/javascript'>alert('" + msg + "');window.history.back();</script>");
                }

            } else {
                // 登录信息格式不正确，返回登录页面
                String msg = "用户信息格式不正确。";
                response.setContentType("text/html;charset=utf8");
                response.getWriter().write("<script>alert(" + msg + ");window.history.back();</script>");
            }
        } else if (Objects.equals("/registerPrompt.do",request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(request,response);
        } else if (Objects.equals("/register.do",request.getServletPath())) {
            // 用户注册
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (RegexUtil.validateUsername(username) && RegexUtil.validatePassword(password)) {
                // 查询用户名是否已存在
                if (userService.findUser(new User(username)) == null) {
                    // 注册成功，跳转到登录页面登录页面
                    userService.register(new User(username, Integer.valueOf(password),new Date(),0));
                    String msg = "注册成功！";
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter writer = response.getWriter();
                    writer.write("<script type='text/javascript'>alert('" + msg + "');window.location.href='/loginPrompt.do'</script>");
                }else {
                    // 用户名已被使用
                    String msg = "用户名已被使用。";
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter writer = response.getWriter();
                    writer.write("<script type='text/javascript'>alert('" + msg + "');window.history.back();</script>");
                }
            }else {
                // 登录信息格式不正确，返回注册页面
                String msg = "用户信息格式不正确。";
                response.setContentType("text/html;charset=utf8");
                PrintWriter writer = response.getWriter();
                writer.write("<script type='text/javascript'>alert('" + msg + "');window.history.back();</script>");
            }
        } else if (Objects.equals("/logout.do",request.getServletPath())) {
            // 退出登录
            request.getSession().setAttribute("username",null);
            request.getRequestDispatcher("/WEB-INF/views/biz/home.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
