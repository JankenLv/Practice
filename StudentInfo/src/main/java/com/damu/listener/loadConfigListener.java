package com.damu.listener;

import com.damu.util.JDBCUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class loadConfigListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JDBCUtil.initSqlSessionFactory();
        System.out.println("==========> 初始化SqlSessionFactory <===========");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JDBCUtil.release();
        System.out.println("==========> 容器销毁中 <===========");
    }
}
