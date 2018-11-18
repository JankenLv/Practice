package com.lvjing.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public class TemplateUtils {

    private static final String dbDriver = "com.mysql.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=utf-8";
    private static final String username = "root";
    private static final String password = "20180226";

    private static BasicDataSource dataSource;
    // 静态初识：创建连接数据源
    static{
    // 创建DBCP简单数据源并初始化相关数据源属性
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 指定数据库连接池初识连接数
        dataSource.setInitialSize(10);
        // 设定同时向数据库申请的最大连接数
        dataSource.setMaxActive(50);
        // 设置连接池中保持的最少连接数
        dataSource.setMinIdle(5);
    }

    public static TransactionTemplate getTransactionTemplate() {
        PlatformTransactionManager txManager = new DataSourceTransactionManager(dataSource);
        return new TransactionTemplate(txManager);
    }

    public static SimpleJdbcInsert getSimpleJdbcTemplate() {
        return new SimpleJdbcInsert(dataSource);
    }

    public static JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 获取事务管理器：TransactionManager
     * 根据需要，可以是如JDBC、Hibernate，这里定义JDBC事务管理
     * @return DataSourceTransactionManager
     */
    public static DataSourceTransactionManager getDataSourceTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        // 设置数据源：此事务数据源须和正式事务管理器的数据源一致
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
