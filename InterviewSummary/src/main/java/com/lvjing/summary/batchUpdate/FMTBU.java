package com.lvjing.summary.batchUpdate;

import com.mysql.jdbc.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * mysql数据库，批量更新的四种方法
 */
public class FMTBU {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/interview_summary?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
    private static final String user = "root";
    private static final String password = "20180226";

    private StringBuilder stb = new StringBuilder();

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet res = null;

    //加载数据库连接配置
    @Before
    public void initConnector() {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 往数据表user插入100条测试数据
     */
    public void addData() throws SQLException {
        stb.append("INSERT INTO user(name,sex,age)VALUES");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                stb.append("('小明").append(i).append("'").append(",'男',").append(i).append("),");
            } else {
                stb.append("('小红").append(i).append("'").append(",'女',").append(i).append("),");
            }
        }
        stb.replace(stb.lastIndexOf(","),stb.lastIndexOf(",")+1,";");
//        System.out.println(data.toString());
        pst = conn.prepareStatement(stb.toString());
        int i = pst.executeUpdate();
        System.out.println("insert success!rows: " + i);
    }

    @Test(timeout = 1000)
    /**
     * 批量更新方法1：循环执行多条UPDATE语句
     * 此方法最原始，效率最慢，性能最差，不建议使用！
     * 耗时：800ms
     */
    public void method1() throws SQLException {
        int j = 99;
        for (int i = 1; i <= 100; i++,j--) {
                stb.append("UPDATE user SET age = ").append(j).append(" WHERE id = ").append(i);
//                System.out.println(stb.toString());
                pst = conn.prepareStatement(stb.toString());
                pst.executeUpdate();
                stb.delete(0,stb.length() + 1);
        }
    }

    @Test(timeout = 1000)
    /**
     * 批量更新方法2：使用mysql的CASE()方法构建批量更新
     * 这种方法只执行一次sql更新多条记录,但是如果要更新多个字段，sql语句会变得很长
     * 耗时：593ms
     */
    public void method2() throws SQLException {
        int[] array = new int[100];
        stb.append("UPDATE user SET age = CASE id\n");
        for (int i = 1; i <= 100; i++) {
            stb.append("WHEN ").append(i).append(" THEN ").append(i).append("\n");
            array[i-1] = i;
        }
        String s = Arrays.toString(array);
        stb.append("END\n").append("WHERE id IN(").append(s.substring(s.indexOf("[") + 1,s.lastIndexOf("]"))).append(")");
//        System.out.println(stb.toString());
        pst = conn.prepareStatement(stb.toString());
        pst.executeUpdate();
    }

    @Test(timeout = 1000)
    /**
     * 批量更新方法3：insert into ... on duplicate key update
     * 这种方法是性能最佳的方法，推荐使用！
     * 耗时：
     */
    public void method3() throws SQLException {
        stb.append("INSERT INTO user(id,age) VALUES\n");
        int j = 99;
        for (int i = 1; i <= 100; i++,j--) {
            stb.append("(").append(i).append(",").append(j).append("),");
        }
        stb.append("ON DUPLICATE KEY UPDATE age = values(age)");
        stb.replace(stb.lastIndexOf(","),stb.lastIndexOf(",") + 1," ");
//        System.out.println(stb.toString());
        pst = conn.prepareStatement(stb.toString());
        pst.executeUpdate();
    }

    @After
    public void release() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
                pst = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (res != null) {
            try {
                res.close();
                res = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试批量插入后的返回值是什么
     * 返回值：受影响的记录数
     */
    @Test
    public void testBatchInsert(){
        for (int i = 0; i < 10; i++) {
            stb.append("('").append("测试数据").append(i).append("'").append(",'男',").append(10+i).append(")").append(",\n");
        }
        System.out.println(stb.toString());
    }

}
