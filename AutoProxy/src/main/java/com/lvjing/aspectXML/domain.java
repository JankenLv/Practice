package com.lvjing.aspectXML;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class domain {

    ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("ApplicationUnderXML.xml");
    }

    @Test
    public void test() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");

        employeeDao.addEmployee();
        employeeDao.updateEmployee();
        employeeDao.findEmployee();
        employeeDao.delEmployee();


    }

}
