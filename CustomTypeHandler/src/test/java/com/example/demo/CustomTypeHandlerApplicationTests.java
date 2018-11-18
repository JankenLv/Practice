package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomTypeHandlerApplication.class})
public class CustomTypeHandlerApplicationTests {

    /**
     * 测试在foreach循环中对集合进行修改，会引发怎样的错误
     */
    @Test
    public void contextLoads() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            System.out.println(s);
            /*if ("1".equals(s)) {
                list.remove(s);
            }*/
        }
        System.out.println(list.get(0));
    }

}
