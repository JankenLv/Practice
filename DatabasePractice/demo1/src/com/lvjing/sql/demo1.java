package com.lvjing.sql;

import com.lvjing.util.JDBCUtil;

import java.sql.*;

public class demo1 {
    private Connection conn = null;
    private Statement stmt= null;
    private ResultSet res = null;

    public static void main(String[] args) {
        new demo1().getDataFromDatabase();
    }

    private void getDataFromDatabase() {
        // SQL语句
//            String sql = "SELECT id,name,price,desp FROM imooc.goods where price < 3500;";
//            String insert = "INSERT goods value(default,\"耳机\",200.0,\"蓝牙耳机\"); ";
//            String insert = "INSERT goods value(default,\"空调\",4000.0,\"变频空调\"); ";
        String querySQL = "SELECT * FROM imooc.goods;";
        String updateSQL = "UPDATE goods SET price = 2500.0 WHERE id = 5;";
        String loginSQL = "SELECT * FROM imooc.goods WHERE id=?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement(loginSQL);
            pstmt.setInt(1,4);
//            pstmt.execute();
//            res = stmt.executeQuery(querySQL);
            printSQL(pstmt.executeQuery());
            /*if (pstmt.execute()) {
                System.out.println("login success");
            } else {
                System.out.println("login fail");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.releaseResource(conn,stmt,res);
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

    private void doUpdate(String updateSQL, String querySQL) {
        // 执行sql，成功后打印出表格所有内容
        try {
                if (stmt.executeUpdate(updateSQL) > 0) {
                    res = stmt.executeQuery(querySQL);
                    printSQL(res);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("操作失败！");
            }
    }

    private void releaseResource() {
        // 数据库连接的资源非常稀有！用完要立刻释放
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

}
