package com.imooc.dao;

import com.imooc.domain.Course;
import com.imooc.domain.User;

import java.util.List;

public interface CourseDao {
    // 验证登录信息
    int login(String username, String password);

    // 添加user
    int addUser(String username, String password);

    // 获取所有user
    List<User> getAllUsers();

    // 根据username删除user
    void delUser(String username);

    // 根据username获取user
    User getUser(String username);

    // 添加course
    void addCourse(Course course);

    // 获取所有course
    List<Course> getAllCourse();

    // 导入course
    void importCourse(List<List<String>> courseList);

    // 清除所有course
    void clearCourse();
}
