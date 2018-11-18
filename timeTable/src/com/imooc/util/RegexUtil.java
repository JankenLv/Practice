package com.imooc.util;

public class RegexUtil {

    public static boolean validateContent(String courseName,String courseType,String description) {
        String pattern = "\\S(\\s|\\S)+";
        return courseName.matches(pattern)&&courseType.matches(pattern)&&description.matches(pattern);
    }
}
