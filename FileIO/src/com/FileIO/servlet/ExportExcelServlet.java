package com.FileIO.servlet;

import com.FileIO.Service.excelService;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 导出excel文件的servlet
 */
@WebServlet("/ExportExcel")
public class ExportExcelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        excelService excelService = new excelService();
        Workbook workbook = excelService.exportExcel();
        String fileName = new String("员工信息登记表.xlsx".getBytes(),"ISO8859-1");
//        String urlName = URLEncoder.encode("员工信息登记表.xlsx","UTF-8");
        response.setHeader("Content-Type","excel/xlsx;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;fileName=" + fileName);
        ServletOutputStream os = response.getOutputStream();

        // 方法1.直接返回文件流供用户下载：
        workbook.write(os);
        os.flush();
        os.close();

        // 方法2.保存文件到硬盘上，再读取文件供用户下载
//        method2(workbook, os);

    }

    /*private void method2(Workbook workbook, ServletOutputStream os) throws IOException {
        // 保存文件到硬盘上
        File file = new File("d:\\export.xlsx");
        FileOutputStream fs = new FileOutputStream(file);
        workbook.write(fs);
        fs.flush();
        fs.close();
        //读取文件供用户下载：
        FileInputStream is = new FileInputStream("d:\\export.xlsx");
        byte[] b = new byte[is.available()];
        is.read(b);

        os.write(b);
        os.flush();
        is.close();
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doPost(request,response);
    }

}
