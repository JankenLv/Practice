package com.imooc.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接数据库的工具类
 */
public class JDBCUtil {
    private static final ComboPooledDataSource cpds = new ComboPooledDataSource();

    public static Connection getConnection() throws Exception{
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
