package com.imooc.service.serviceImpl;

import com.imooc.dao.CourseDao;
import com.imooc.dao.daoImpl.CourseDaoImpl;
import com.imooc.domain.Course;
import com.imooc.domain.User;
import com.imooc.service.CourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();

    // 登录验证
    @Override
    public int login(String username, String password) {
        return courseDao.login(username,password);
    }

    // 添加管理员
    @Override
    public int addUser(String username, String password) {
        return courseDao.addUser(username,password);
    }

    // 获取所有管理员
    @Override
    public List<User> getAllUsers() {
        return courseDao.getAllUsers();
    }

    // 删除管理员
    @Override
    public void delUser(String username) {
        courseDao.delUser(username);
    }

    // 获取管理员
    @Override
    public User getUser(String username) {
        return courseDao.getUser(username);
    }

    // 添加课程
    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    // 获取所有课程
    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    // 导入课程
    @Override
    public void importCourse(List<List<String>> courseList) {
        courseDao.importCourse(courseList);
    }

    // 导出课程
    @Override
    public void exportCourse(JSONArray result, HttpServletResponse response) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");

        // 写excel表头：
        Row rowHeader = sheet.createRow(0);
        rowHeader.createCell(0).setCellValue("课程ID");
        rowHeader.createCell(1).setCellValue("课程名");
        rowHeader.createCell(2).setCellValue("方向");
        rowHeader.createCell(3).setCellValue("描述");
        rowHeader.createCell(4).setCellValue("时长(小时)");
        rowHeader.createCell(5).setCellValue("操作人");

        // 写excel数据：
        for (int i = 0; i < result.size(); i++) {
            Row row = sheet.createRow(i + 1);
            JSONObject jsonObject = result.getJSONObject(i);
            row.createCell(0).setCellValue(jsonObject.getString("id"));
            row.createCell(1).setCellValue(jsonObject.getString("courseName"));
            row.createCell(2).setCellValue(jsonObject.getString("courseType"));
            row.createCell(3).setCellValue(jsonObject.getString("description"));
            row.createCell(4).setCellValue(jsonObject.getString("courseTime"));
            row.createCell(5).setCellValue(jsonObject.getString("operator"));
        }
//        return workbook;
        String fileName = "课表.xlsx";
        try {
            fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setContentType("excel/xlsx;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;fileName=" + fileName);
        ServletOutputStream os = null;
        try {
            os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 清空课程
    @Override
    public void clearCourse() {
        courseDao.clearCourse();
    }
}
