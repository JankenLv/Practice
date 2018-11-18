package com.lvjing.hd.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DispatcherServlet extends GenericServlet {

    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath();
        path = path.substring(1).substring(0,path.indexOf(".do")-1);
        String beanName = null;
        String methodName = null;
        int index = path.lastIndexOf("/");
        if (index != -1) {
            beanName = path.substring(0, index) + "Controller";
            methodName = path.substring(index+1);
        } else {
            beanName = "authController";
            methodName = path;
        }

        Object bean = context.getBean(beanName);
        try {
            Method method = bean.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(bean,request,response);
        } catch ( NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
