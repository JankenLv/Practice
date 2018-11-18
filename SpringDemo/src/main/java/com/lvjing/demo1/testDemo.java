package com.lvjing.demo1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")*/
public class testDemo {

    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    /*@Resource(name = "productDao")
    private ProductDao productDao;*/

    @Test
    public void demo() {
        ProductDao productDao = (ProductDao) context.getBean("proxyProduct");
        productDao.addProduct();
        productDao.findProduct();
        productDao.updateProduct();
        productDao.delProduct();
    }

}
