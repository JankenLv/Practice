package net.xdclass.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//底层用junit
@SpringBootTest(classes = {Application.class})//指定入口类，启动工程
public class SpringBootTestDemo {

    @Test
    public void testOne() {
        System.out.println("========= test hello =========");
    }


}
