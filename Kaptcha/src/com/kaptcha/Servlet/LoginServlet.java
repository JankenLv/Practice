package com.kaptcha.Servlet;

import com.google.gson.JsonArray;
import org.aspectj.bridge.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 获取用户输入的登录验证信息：
        String inputKaptcha = request.getParameter("inputKaptcha");
        System.out.println("inputKaptcha: " + inputKaptcha);

        // 获取系统生成的验证码：
        String kaptcha = (String)request.getSession().getAttribute(com.mysql.jdbc.Constants.KAPTCHA_SESSION_KEY);
        System.out.println("kaptcha: " + kaptcha);

        // 判断验证码是否正确：
        if(inputKaptcha != null && kaptcha.equalsIgnoreCase(inputKaptcha)){
            // 验证码正确，返回登录成功信息：
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("1");
            jsonArray.add("验证码输入正确，登录成功！");
            System.out.println("jsonArray: " + jsonArray);
            String array = jsonArray.toString();
            response.getWriter().write(array);
        }else{
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("0");
            jsonArray.add("验证码输入错误，登录失败！");
            System.out.println("jsonArray: " + jsonArray);
            String array = jsonArray.toString();
            response.getWriter().write(array);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
