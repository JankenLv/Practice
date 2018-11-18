package com.ljs.export;

import com.ljs.export.service.ExportCSVService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportApplicationTests {

    @Autowired
    private ExportCSVService exportCSVService;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试apache的csv工具导出文件是否乱码
     */
    @Test
    public void testExportCSV() {
        exportCSVService.generateCSV();
    }

    /**
     * 测试CSV使用带BOM UTF-8编码，excel打开是否乱码
     */
    @Test
    public void testCSVWithBOM() {
        exportCSVService.generateCSVWithBOM();
    }

}
