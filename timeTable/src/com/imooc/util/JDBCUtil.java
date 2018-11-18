package com.imooc.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC工具类
 * 获取数据库连接
 * 释放资源
 */
public class JDBCUtil {

    // 获取连接
    public static Connection getConnection() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        // c3p0配置
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql:///imooc?useUnicode=true&characterEncoding=UTF-8");
        cpds.setUser("root");
        cpds.setPassword("20180226");
        cpds.setInitialPoolSize(1);
        cpds.setMaxPoolSize(30);

        return cpds.getConnection();
    }

    // 释放资源
    public static void releaseResource(Connection conn, Statement stmt, ResultSet res) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (res!=null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        }
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
