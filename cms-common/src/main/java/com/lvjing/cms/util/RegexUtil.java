package com.lvjing.cms.util;

/**
 * 正则表达式验证工具类
 */
public class RegexUtil {

    /**
     * 验证用户名
     * @param username 用户名
     * @return 验证结果
     */
    public static boolean validateUsername(String username) {
        String pattern = "([0-9a-zA-Z]){5,12}";
        return username.matches(pattern);
    }

    /**
     * 验证用户密码
     * @param password 密码
     * @return 验证结果
     */
    public static boolean validatePassword(String password) {
        String pattern = "([0-9]){6,12}";
        return password.matches(pattern);
    }

    /**
     * 验证油画id
     * @param id 油画id
     * @return 验证结果
     */
    public static boolean validateCanvasId(String id) {
        String pattern = "([0-9])*";
        return id.matches(pattern);
    }

    /**
     * 验证油画分类id
     * @param categoryId 油画分类id
     * @return 验证结果
     */
    public static boolean validateCanvasCategoryId(String categoryId) {
        String pattern = "([0-9])*";
        return categoryId.matches(pattern);
    }

    /**
     * 验证油画价格
     * @param price 油画价格
     * @return 验证结果
     */
    public static boolean validateCanvasPrice(String price) {
        String pattern = "([0-9]*)|([0-9]+\\.([0-9])+)";
        return price.matches(pattern);
    }
}
