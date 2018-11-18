package com.lvjing.bm.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 请求分发servlet
 */
public class DispatcherServlet extends GenericServlet {

    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = this.getServletContext();
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath().substring(1);
        String beanName = null;
        String methodName = null;
        int index = path.lastIndexOf("/");
        if (index != -1) {
            beanName = path.substring(0, index) + "Controller";
            methodName = path.substring((index + 1), path.lastIndexOf(".do"));
        } else {
            beanName = "selfController";
            methodName = path.substring(0,path.lastIndexOf(".do"));
        }

        Object bean = context.getBean(beanName);
        try {
            Method method = bean.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(bean,request,response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
