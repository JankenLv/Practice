package com.ljs.export.service;

import com.csvreader.CsvReader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 导入CSV业务类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/8 20:54 </p>
 */
@Service
public class ImportCSVService {

    private static final String filePath = "C:\\Users\\lvjin\\Desktop\\测试.csv";

    /**
     * 使用InputStreamReader读取CSV文件内容
     *
     * @param is
     */
    public List<String[]> getCsvContentWithReader(InputStream is) throws IOException {
        // 通过InputStreamReader，使用指定的编码把输入流转换为字符流
        InputStreamReader reader = new InputStreamReader(is, Charset.forName("UTF-8"));
        CsvReader csvReader = new CsvReader(reader);
        List<String[]> content = new ArrayList<>();
        String[] headers = csvReader.getHeaders();
        content.add(headers);
        while (csvReader.readRecord()) {
            String[] line = csvReader.getValues();
            content.add(line);
        }

        if (!(StringUtils.isEmpty(content) || content.isEmpty())) {
            for(String[] strings : content) {
                System.out.println("文件内容：" + Arrays.toString(strings) + "\n");
            }
        }
        return content;
    }

    /**
     * 使用InputStream读取CSV文件内容
     *
     * @param is
     */
    public List<String[]> getCsvContent(InputStream is) throws IOException {
        CsvReader csvReader = new CsvReader(is,Charset.forName("UTF-8"));
        List<String[]> content = new ArrayList<>();
        String[] headers = csvReader.getHeaders();
        content.add(headers);
        while (csvReader.readRecord()) {
            String[] line = csvReader.getValues();
            content.add(line);
        }

        if (!(StringUtils.isEmpty(content) || content.isEmpty())) {
            for(String[] strings : content) {
                System.out.println("文件内容(不使用reader)：" + Arrays.toString(strings) + "\n");
            }
        }
        return content;
    }

    /**
     * 使用FileReader读取CSV文件内容
     *
     */
    public List<String[]> getCsvContentWithFileReader() throws IOException {
        FileReader reader = new FileReader(filePath);
        CsvReader csvReader = new CsvReader(reader);

        List<String[]> content = new ArrayList<>();
        String[] headers = csvReader.getHeaders();
        content.add(headers);
        while (csvReader.readRecord()) {
            String[] line = csvReader.getValues();
            content.add(line);
        }

        if (!(StringUtils.isEmpty(content) || content.isEmpty())) {
            for(String[] strings : content) {
                System.out.println("文件内容(不使用reader)：" + Arrays.toString(strings) + "\n");
            }
        }
        return content;
    }
}
