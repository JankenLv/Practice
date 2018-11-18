package com.lvjing.cms.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * 加载mybatis配置文件、
 * 获取sqlSessionFactory的工具类
 */
public class JDBCUtil {

    /**
     * 初始化mybatis配置
     */
    private static String resource = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;

    public static void initialMybatis() {
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("初始化mybatis配置失败");
        }
    }

    /**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    /**
     * 释放资源
     */
    public static void destroyMybatis() {
        sqlSessionFactory=null;
        resource=null;
    }

}
