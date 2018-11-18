package com.FileIO.servlet;

import com.FileIO.Service.wordService;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 导出word文件的servlet
 */
@WebServlet("/ExportWord")
public class ExportWordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // word模板要替换的内容
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("${name}",request.getParameter("name"));
        paramMap.put("${age}",request.getParameter("age"));
        paramMap.put("${time}",request.getParameter("time"));

        String fileName = new String("报名表.doc".getBytes(),"ISO-8859-1");
        String name = "中文名 带空格.doc";
        byte[] b = name.getBytes();
        name = new String(b,"ISO-8859-1");
        // firefox处理文件名有空格被截断的方法：在文件名两边加上“ ”
        String content = String.format("attachment; filename=\"%s\"",name);
        response.setHeader("Content-Type", "word/doc;charset=utf-8");
        response.setHeader("Content-Disposition", content);
        ServletOutputStream os = response.getOutputStream();
        wordService wordService = new wordService();
        // 判断导出那个版本的word
        try {
            if ("03".equals(request.getParameter("version"))) {
                HWPFDocument hwpfDocument = wordService.export03(paramMap, request.getServletContext().getInitParameter("word03"));
                hwpfDocument.write(os);
            } else if ("07".equals(request.getParameter("version"))) {
                XWPFDocument xwpfDocument = wordService.export07(paramMap, request.getServletContext().getInitParameter("word07"));
                xwpfDocument.write(os);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            os.flush();
            os.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.doPost(request, response);
    }

}
