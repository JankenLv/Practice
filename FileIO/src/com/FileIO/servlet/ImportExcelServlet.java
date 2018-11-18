package com.FileIO.servlet;

import com.FileIO.Dto.fileItemDto;
import com.FileIO.Dto.importExcelResultDto;
import com.FileIO.Service.excelService;
import com.FileIO.Utils.ParseRequestUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 导入excel文件的servlet
 */
@WebServlet("/ImportExcel")
public class ImportExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            // 包含上传文件的 request 请求
            excelService excelService = new excelService();
            importExcelResultDto resultDto = new importExcelResultDto();
            try {
                fileItemDto fileItemDto = ParseRequestUtil.parse(request);
                String title = excelService.parseFormfield(fileItemDto.getFileItemMap().get("title"));
                List<List<String>> content = excelService.parseExcel(fileItemDto.getFileItemMap().get("excel"));
                resultDto.setTitle(title);
                resultDto.setSheet(content);
            } catch (Exception e) {
                resultDto.setExceptionMsg("上传文件格式错误！（非excel格式）");
                System.out.println("上传文件格式错误！（非excel格式）");
                e.printStackTrace();
            }

            request.setAttribute("resultDto", resultDto);
            if (resultDto.getExceptionMsg() != null) {
                request.getRequestDispatcher("/WEB-INF/jsp/importExcel.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/importExcelResult.jsp").forward(request,response);
            }

        } else {
            // 普通请求
            System.out.println("is a normal request");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
