package com.imooc.filter;

import com.imooc.domain.User;
import com.imooc.service.CourseService;
import com.imooc.service.serviceImpl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * 对不同用户进行权限筛选的过滤器
 */
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
//        HttpServletResponse httpResponse = (HttpServletResponse)response;

        CourseService courseService = new CourseServiceImpl();
//        String username = (String) httpRequest.getSession().getAttribute("username");
        String username = (String) httpRequest.getSession().getAttribute("username");
        User user =  courseService.getUser(username);
        String auth = user.getAuthority();
//        User user = (User) httpRequest.getAttribute("user");

        if (Objects.equals("超级管理员",auth)) {
            request.setAttribute("flag","1");
//            chain.doFilter(httpRequest,httpResponse);
            chain.doFilter(request ,response);
        } else if (Objects.equals("普通管理员", auth)) {
            request.setAttribute("flag","0");
//            chain.doFilter(httpRequest,httpResponse);
            chain.doFilter(request ,response);
        }
    }
}
