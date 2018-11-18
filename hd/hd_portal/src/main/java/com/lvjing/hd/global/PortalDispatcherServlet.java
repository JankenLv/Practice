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

/**
 * 请求分发servlet
 */
public class PortalDispatcherServlet extends GenericServlet {

    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath().substring(1);
        String beanName = "portalController";
        String methodName = null;
        int index = path.lastIndexOf("/");
        if (index != -1) {
            methodName = path.substring((index+1), path.indexOf(".do"));
        } else {
            methodName = path.substring(0,path.indexOf(".do"));
        }

        Object bean = context.getBean(beanName);
        try {
            Method method = bean.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(bean, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
