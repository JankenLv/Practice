package com.lvjing.domain;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class demo {


    @Test
    public void testDemo() {
        ApplicationContext context = new GenericXmlApplicationContext("ApplicationContext.xml");
//        ProductDao food = (ProductDao) context.getBean("food");
        Object food = context.getBean("food");
        System.out.println(food);
    }
}
