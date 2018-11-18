package com.ljs.export.service;

import com.csvreader.CsvWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

/**
 * 导出CSV文件
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/6 22:55 </p>
 */
@Service
public class ExportCSVService {

    private static final String[] header = {"序号","姓名","年龄","性别","出生日期"};

    private static final String[] data = {"1","小明","28","男","1998-08-10"};

    private static final String filePath = "C:\\Users\\lvjin\\Desktop\\测试.csv";

    private static final String inputPath = "C:\\Users\\lvjin\\Desktop\\input.csv";

    private static final String outputPath = "C:\\Users\\lvjin\\Desktop\\output1.csv";

    /**
     * 生成CSV文件（无BOM UTF-8编码）
     *
     */
    public void generateCSV() {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.EXCEL)) {
            printer.printRecord("id", "userName", "firstName", "lastName", "birthday");
            printer.printRecord(1, "小明", "李", "leo", LocalDate.of(1973, 9, 15));
            printer.println();
            printer.printRecord(2, "玛丽", "超级", "susan", LocalDate.of(1985, 3, 29));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 生成CSV文件（带BOM UTF-8编码）
     */
    public void generateCSVWithBOM() {
        try {
            FileInputStream fis = new FileInputStream(inputPath);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);


            FileOutputStream fos = new FileOutputStream(outputPath);
            fos.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);

            String line;
            while((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
