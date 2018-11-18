package com.lvjing.sql;

import com.lvjing.util.JDBCUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.PropertyConfigurator;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接池C3P0演示
 */
public class demo2 {

    public static void main(String[] args) {
        try {
            URL log4jUrl = demo2.class.getClassLoader().getResource("log4j.properties");
            PropertyConfigurator.configure(log4jUrl);
            /*URL url = demo2.class.getClassLoader().getResource("c3p0-config.xml");
            System.out.println(url);*/
            new demo2().doC3P0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doC3P0(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            ComboPooledDataSource c3p0 = new ComboPooledDataSource();
            /*c3p0.setDriverClass("com.mysql.jdbc.Driver");
            c3p0.setJdbcUrl("jdbc:mysql:///imooc?characterEncoding=UTF-8");
            c3p0.setUser("root");
            c3p0.setPassword("20180226");

            c3p0.setInitialPoolSize(10);
            c3p0.setMaxPoolSize(30);*/

            String querySQL = "SELECT * FROM imooc.goods";

            conn = c3p0.getConnection();
            pstmt = conn.prepareStatement(querySQL);
            res = pstmt.executeQuery();
            printSQL(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.releaseResource(conn,pstmt,res);
        }

    }

    private void printSQL(ResultSet res) {
        try {
            while (res.next()) {
                System.out.println(res.getString("id") + " " + res.getString("name")
                        + "  " + res.getString("price") + " " + res.getString("desp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
