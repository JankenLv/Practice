package com.damu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class JDBCUtil {

    private static String resource = "mybatis-config.xml";

    private static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> threadLocal= new ThreadLocal<>();

    public static void initSqlSessionFactory(){
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            System.out.println(threadLocal.get()!=null?"threadLocal不为空":"threadLocal为空");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void release() {
        if (threadLocal.get() != null) {
            System.out.println("threadLocal.get(): " + threadLocal.get());
            threadLocal.get().close();
            threadLocal.set(null);
        } else {
            System.out.println("threadLocal.get(): 为空");
        }
    }

}
