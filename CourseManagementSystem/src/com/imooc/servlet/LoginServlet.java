package com.imooc.servlet;

import com.google.code.kaptcha.Constants;
import com.imooc.service.CourseService;
import com.imooc.service.serviceImpl.CourseServiceImpl;
import com.imooc.utils.RegexUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 验证用户登录信息的servlet
 */
public class LoginServlet extends HttpServlet {

    private String checkLoginInfo(String username, String password,String kaptchaValue, String inputCode) {
        CourseService service = new CourseServiceImpl();
        String loginResult = "";
        if (RegexUtil.validateUsername(username) && RegexUtil.validatePassword(password)) {
            if (Objects.equals(kaptchaValue, inputCode)) {
                int loginStatus = service.login(username, password);
//                    loginResult = String.valueOf(loginStatus);
                switch (loginStatus) {
                    case 1:
                        // 登录成功
                        loginResult = "loginSuccess";
                        break;
                    case 0:
                        loginResult = "密码错误！";
                        break;
                    case -1:
                        loginResult = "用户不存在！";
                        break;
                }
            } else {
                // 验证码错误
                loginResult = "验证码错误!";
            }
        } else {
            // 登录信息格式有误
            loginResult = "登录信息格式有误";
        }

        return loginResult;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (Objects.equals("/checkLoginInfo",request.getServletPath())) {
            String kaptchaValue = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String inputCode = request.getParameter("checkCode");
            String loginResult = checkLoginInfo(username,password,kaptchaValue,inputCode);

            response.setContentType("text/String;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(loginResult);
            writer.flush();
            writer.close();
        } else if (Objects.equals("/login", request.getServletPath())) {
            CourseService service = new CourseServiceImpl();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (service.login(username, password) == 1) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/goTo?page=server");
            } else {
                response.sendRedirect(request.getContextPath() + "/goTo?page=index");
            }

        }
    }
}
