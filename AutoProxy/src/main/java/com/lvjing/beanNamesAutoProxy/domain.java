package com.lvjing.beanNamesAutoProxy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringRunner.class)
//@ContextConfiguration("classpath:ApplicationContext.xml")
public class domain {

    ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void test() {
        FoodDao foodDao = (FoodDao) context.getBean("foodDao");
        CarDao carDao = (CarDao) context.getBean("carDao");

        foodDao.addFood();
        foodDao.findFood();
        foodDao.updateFood();
        foodDao.delFood();

        carDao.addCar();
        carDao.findCar();
        carDao.updateCar();
        carDao.delCar();
    }

}
