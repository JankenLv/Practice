package com.lvjing.main;

import java.sql.*;

public class JDBCUtil {

    private static Connection conn;
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static{
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql:///message_board?useUnicode=true&characterEncoding=utf-8";
        username = "root";
        password = "20180226";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return  conn = DriverManager.getConnection(url,username,password);
    }

    public static void release(Connection conn, Statement stmt, ResultSet res) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (stmt!=null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        if (res!=null) {
                            try {
                                res.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
