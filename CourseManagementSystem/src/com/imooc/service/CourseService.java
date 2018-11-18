package com.imooc.service;

import com.imooc.domain.Course;
import com.imooc.domain.User;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CourseService {
    // 登录验证
    int login(String username, String password);
    // 添加管理员
    int addUser(String username, String password);
    // 获取所有管理员
    List<User> getAllUsers();
    // 删除管理员
    void delUser(String username);
    // 添加课程
    void addCourse(Course course);
    // 获取管理员
    User getUser(String username);
    // 获取所有课程
    List<Course> getAllCourse();
    // 导入课程
    void importCourse(List<List<String>> courseList);
    // 导出课程
    void exportCourse(JSONArray result, HttpServletResponse response);
    // 清除所有课程
    void clearCourse();
}
