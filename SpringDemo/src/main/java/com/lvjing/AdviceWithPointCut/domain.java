package com.lvjing.AdviceWithPointCut;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class domain {

    private ClassPathXmlApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void dodo() {
        Book bookProxy = (Book) context.getBean("bookProxy");
        bookProxy.addBook();
        bookProxy.findBook();
        bookProxy.updateBook();
        bookProxy.delBook();

    }


}
