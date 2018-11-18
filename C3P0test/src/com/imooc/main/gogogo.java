package com.imooc.main;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class gogogo {

    public static void main(String[] args) throws PropertyVetoException {
        new gogogo().domain();
    }

    private void domain() throws PropertyVetoException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;

        ComboPooledDataSource cpds = new ComboPooledDataSource();

        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql:///imooc");
        cpds.setUser("root");
        cpds.setPassword("20180226");
        cpds.setInitialPoolSize(1);
        cpds.setMaxPoolSize(30);

        try {
            conn = cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    }
}
