package com.FileIO.servlet;

import com.FileIO.Dto.fileItemDto;
import com.FileIO.Dto.importWordResultDto;
import com.FileIO.Service.wordService;
import com.FileIO.Utils.ParseRequestUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 导入word文件的servlet
 */
@WebServlet("/ImportWord")
public class ImportWordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            // 包含上传文件的请求
            wordService wordService = new wordService();
            importWordResultDto resultDto = new importWordResultDto();
            try {
                fileItemDto fileItemDto = ParseRequestUtil.parse(request);
                resultDto.setTitle(wordService.parseFormfield(fileItemDto.getFileItemMap().get("title")));
                resultDto.setContent(wordService.parseDocument(fileItemDto.getFileItemMap().get("word")));
            }catch (Exception e) {
                resultDto.setExceptionMsg("上传文件格式错误！（非word文档）");
                System.out.println("上传文件格式错误！（非word文档）");
                e.printStackTrace();
            }

            request.setAttribute("resultDto",resultDto);
            if (resultDto.getExceptionMsg()!=null) {
                request.getRequestDispatcher("/WEB-INF/jsp/importWord.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/WEB-INF/jsp/importWordResult.jsp").forward(request,response);
            }
        }else{
            // 普通请求
            System.out.println("is a normal request");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

}
