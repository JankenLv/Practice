package com.lvjing.it.interceptor;

import com.lvjing.it.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("SpringMVC拦截器预处理");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("session_user");
        if (user != null) {
            if (user.getAccount().equals("小明") && user.getPassword().equals("123456")) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/auth/toLogin");
                return false;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/auth/toLogin");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("SpringMVC拦截器后处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("SpringMVC拦截器最后处理");
    }
}
