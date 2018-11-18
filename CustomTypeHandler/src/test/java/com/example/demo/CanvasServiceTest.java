package com.example.demo;

import com.example.demo.service.CanvasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomTypeHandlerApplication.class})
public class CanvasServiceTest {

    @Autowired
    private CanvasService canvasService;

    /**
     * 测试mybatis结果集一条记录结果集映射到Boolean类型
     */
    @Test
    public void oneRowToBoolean() {
        Boolean result = canvasService.checkBooleanOfOneRow(100);
        System.out.println("================》》》一条记录映射结果：" + result);
    }

    /**
     * 测试mybatis结果集多条记录结果集映射到Boolean类型
     */
    @Test
    public void multiRowToBoolean() {
        Boolean result = canvasService.checkBooleanOfMultiRow("日出印象");
        System.out.println("================》》》多条记录映射结果：" + result);
    }

}
