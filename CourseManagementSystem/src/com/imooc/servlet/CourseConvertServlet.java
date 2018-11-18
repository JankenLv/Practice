package com.imooc.servlet;

import com.imooc.service.CourseService;
import com.imooc.service.serviceImpl.CourseServiceImpl;
import com.imooc.utils.ExcelHandler;
import com.imooc.utils.RequestParser;
import net.sf.json.JSONArray;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * 导入、导出课程信息的servlet
 */
public class CourseConvertServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/importCourse", request.getServletPath())) {
            // 批量导入课程
            CourseService courseService = new CourseServiceImpl();
            try {
                FileItem uploadFile = RequestParser.getUploadFile(request);
                List<List<String>> excelData = ExcelHandler.getExcelData(uploadFile);
                courseService.importCourse(excelData);
                response.sendRedirect(request.getContextPath() + "/getAllCourses");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg","导入文件格式有误！");
                request.getRequestDispatcher("/goTo?page=courseImport").forward(request,response);
            }
        } else if (Objects.equals("/exportCourse", request.getServletPath())) {
             // 导出课程为excel表格
            String export = (String) request.getSession().getAttribute("export");
            Object object = null;

            if (Objects.equals("result",export)) {
                object = request.getSession().getAttribute("result");
            }else if (Objects.equals("subResult",export)){
                object = request.getSession().getAttribute("subResult");
            }

            if (object != null) {
                JSONArray result = JSONArray.fromObject(object);
                if (result.size()!=0) {
                    CourseService courseService = new CourseServiceImpl();
                    courseService.exportCourse(result,response);
                }else{
                    request.setAttribute("msg","没有选择任何课程！导出终止！");
                    request.getRequestDispatcher("/goTo?page=warning").forward(request,response);
                }
            }else{
                request.setAttribute("msg","没有选择任何课程！导出终止！");
                request.getRequestDispatcher("/goTo?page=warning").forward(request,response);
            }
        }
    }
}
