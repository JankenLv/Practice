package com.ljs.export.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;

/**
 * 导出CSV文件，使用BOM头的UTF-8编码
 * 解决Excel读取CSV文件乱码问题
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/7 8:08 </p>
 */
@Controller
public class ExportCSVWithBOMController {

    private static final String inputPath = "C:\\Users\\lvjin\\Desktop\\input.csv";

    private static final String outputPath = "C:\\Users\\lvjin\\Desktop\\output.csv";

    @GetMapping("/api/v1/export/csv")
    public void exportCSV(){
        try {
            FileInputStream fis = new FileInputStream("input.csv");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream("output.csv");
            fos.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
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
