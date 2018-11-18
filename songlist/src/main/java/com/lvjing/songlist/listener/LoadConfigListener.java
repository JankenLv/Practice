package com.lvjing.songlist.listener;

import com.lvjing.songlist.util.JDBCUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LoadConfigListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        JDBCUtil.initSqlSessionFactory();
        System.out.println("============》》》成功加载mybatis配置》》》===========");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        JDBCUtil.destroySqlSessionFactory();
    }
}
