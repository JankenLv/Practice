package com.imooc.utils;

/**
 * 正则表达式验证工具类
 */
public class RegexUtil {
    private RegexUtil(){};

    public static boolean validateUsername(String username) {
        String usernamePattern = "\\w{3,12}";
        return username.matches(usernamePattern);
    }
    public static boolean validatePassword(String password) {
        String passwordPattern = "\\w{5,12}";
        return password.matches(passwordPattern);
    }
    public static boolean validateCourseId(String courseId) {
        String courseIdPattern = "[1-9]\\d{0,2}";
        return courseId.matches(courseIdPattern);
    }
    public static boolean validateCourseTime(String courseTime) {
        String courseTimePattern = "[1-9]\\d{0,2}(\\.\\d)?";
        return courseTime.matches(courseTimePattern);
    }
}
