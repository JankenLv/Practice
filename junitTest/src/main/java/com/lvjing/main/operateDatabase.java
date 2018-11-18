package com.lvjing.main;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class operateDatabase {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet res = null;

    @Ignore
    public void addUser() {

        String addUser = "INSERT INTO message_board.user(username, password) VALUE(?,?)";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(addUser);
            stmt.setString(1,"李晓明");
            stmt.setString(2,"123456");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(conn,stmt,res);
        }
    }

    @Test
    public void testDate() {
//        String str = "2018/02/26";
        String str = "2018-02-26";
//        Long l = 2018L;
//        Date date = new Date(l);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            System.out.println(format.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        java.util.Date dd = new java.util.Date();
//        System.out.println(date);
//        System.out.println(dd);
    }
}
