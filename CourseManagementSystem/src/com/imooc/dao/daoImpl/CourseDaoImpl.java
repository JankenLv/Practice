package com.imooc.dao.daoImpl;

import com.imooc.dao.CourseDao;
import com.imooc.domain.Course;
import com.imooc.domain.User;

import java.util.*;

public class CourseDaoImpl implements CourseDao {
    private static final List<User> usersTable;
    private static final List<Course> coursesTable;

    static {
        usersTable = new ArrayList<>();
        coursesTable = new ArrayList<>();

        // 初始化超级管理员imooc:
        usersTable.add(new User("imooc","imooc","超级管理员"));
    }

    public CourseDaoImpl(){

    }

    /**
     * 验证登录信息
     * 返回0：密码错误；返回1：用户信息正确；返回-1：用户不存在。
     */
    @Override
    public int login(String username, String password) {
        int loginStatus = -1;
        for(User user : usersTable) {
            if (Objects.equals(username, user.getUsername())) {
                if (Objects.equals(password, user.getPassword())) {
                    loginStatus = 1;
                    break;
                }
                loginStatus = 0;
                break;
            }
        }
        return loginStatus;
    }

    // 添加课程
    @Override
    public void addCourse(Course course) {
        coursesTable.add(course);
    }

    // 获取所有user信息
    @Override
    public List<User> getAllUsers() {
        return usersTable;
    }

    /**
     * 添加管理员
     * 返回-1：用户名已被使用，操作失败；返回1：操作成功。
     */
    @Override
    public int addUser(String username, String password) {
        boolean isUsernameExist = false;
        for(User user : usersTable) {
            if (Objects.equals(username, user.getUsername())) {
                isUsernameExist = true;
                break;
            }
        }
        if (isUsernameExist) {
            return -1;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            usersTable.add(user);
            return 1;
        }
    }

    // 根据用户名获取user
    @Override
    public User getUser(String username) {
        for(User user : usersTable) {
            if (Objects.equals(username, user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    // 根据用户名删除user
    @Override
    public void delUser(String username) {
        if (!Objects.equals("imooc", username)) {
            for(User user : usersTable) {
                if (Objects.equals(username, user.getUsername())) {
                    usersTable.remove(user);
                    break;
                }
            }
        }
    }

    // 获取所有course
    @Override
    public List<Course> getAllCourse() {
        return coursesTable;
    }

    // 导入course
    @Override
    public void importCourse(List<List<String>> excelData) {
        for (int i=1; i<excelData.size();i++) {
            Course course = new Course();
            for (int j = 0; j < excelData.get(i).size(); j++) {
                course.setId(excelData.get(i).get(0));
                course.setCourseName(excelData.get(i).get(1));
                course.setCourseType(excelData.get(i).get(2));
                course.setDescription(excelData.get(i).get(3));
                course.setCourseTime(excelData.get(i).get(4));
                course.setOperator(excelData.get(i).get(5));
            }
            coursesTable.add(course);
        }
    }

    // 清除所有course（开发测试用）
    @Override
    public void clearCourse() {
        coursesTable.clear();
    }
}
