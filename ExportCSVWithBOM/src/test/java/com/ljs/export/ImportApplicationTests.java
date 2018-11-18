package com.ljs.export;

import com.ljs.export.service.ImportCSVService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 导入、解析CSV文件测试类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/9 8:30 </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportApplicationTests {

    @Autowired
    private ImportCSVService importCSVService;

    @Test
    public void testFileReaderParseCSV() throws IOException {
        importCSVService.getCsvContentWithFileReader();
    }

}
