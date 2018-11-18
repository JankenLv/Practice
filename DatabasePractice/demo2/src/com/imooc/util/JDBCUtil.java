package com.imooc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 连接数据库的工具类
 */
public class JDBCUtil {
    private static final String url;
    private static final String username;
    private static final String password;
    private static final String driver;

    static{
        Properties prop = new Properties();
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = prop.getProperty("url");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        driver = prop.getProperty("driver");
    }

    public static Connection getConnection() throws Exception{
        loadDriver();
        return DriverManager.getConnection(url,username,password);
    }


    // 加载驱动
    private static void loadDriver() throws ClassNotFoundException {
        Class.forName(driver);
    }

    // 释放资源
    public static void releaseResource(Connection conn, Statement stmt, ResultSet res) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (res!=null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            res = null;
        }
    }

    // 释放资源
    public static void releaseResource(Connection conn, Statement stmt) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
    }
}
