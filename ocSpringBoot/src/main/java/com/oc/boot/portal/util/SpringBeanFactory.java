package com.oc.boot.portal.util;


import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class SpringBeanFactory {

    public static Object getBean(String beanName) {
        String[] path = {"application.yml"};
        return getBean(path,beanName);
    }

    public static Object getBean(String[] path, String beanName) {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocations(path);
        context.setServletContext(new MockServletContext());
        context.refresh();
        return context.getBean(beanName);
    }

}
