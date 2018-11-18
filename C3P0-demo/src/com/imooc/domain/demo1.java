package com.imooc.domain;

import com.imooc.util.JDBCUtil;
import com.imooc.util.JDBCUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class demo1 {


    public static void main(String[] args) {
        //URL url = demo1.class.getClassLoader().getResource("log4j.properties");
        //System.out.println(url);
        new demo1().doC3P0();
    }

    private void doC3P0() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        String querySQL = "SELECT * FROM imooc.course";

//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(querySQL);
            res = pstmt.executeQuery();
            System.out.println(res.next()?"success":"failed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil2.releaseResource(conn,pstmt,res);
        }
    }
}
