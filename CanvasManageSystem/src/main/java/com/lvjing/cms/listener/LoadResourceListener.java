package com.lvjing.cms.listener;

import com.lvjing.cms.util.JDBCUtil;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 加载mybatis配置文件和log4j配置文件的listener
 */
@WebListener
public class LoadResourceListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JDBCUtil.initialMybatis();
        String contextPath = sce.getServletContext().getRealPath("/");
        String log4jPath = "/WEB-INF/classes/log4j.properties";
        String realPath = contextPath + log4jPath;
        PropertyConfigurator.configure(realPath);
        System.out.println("============== servlet initialize , load configuration ============");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JDBCUtil.destroyMybatis();
        System.out.println("============== servlet destroy ============");
    }
}
