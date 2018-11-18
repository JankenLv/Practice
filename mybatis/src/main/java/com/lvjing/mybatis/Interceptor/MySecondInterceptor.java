package com.lvjing.mybatis.Interceptor;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

// 使用注解标注需要拦截的方法
@Intercepts({
        @Signature(type = ResultSetHandler.class,method = "handleResultSets",args = {Statement.class})
})
public class MySecondInterceptor implements Interceptor {

    // 执行目标对象的方法
    public Object intercept(Invocation invocation) throws Throwable {
        Object proceed = invocation.proceed();
        Object target = invocation.getTarget();
        String name = invocation.getMethod().getName();
        System.out.println("\n第二层-目标方法被执行=======");
        System.out.println("第二层-目标：" + target + " 第二层-目标方法：" + name);
        return proceed;
    }

    // 拦截、包装目标对象
    public Object plugin(Object o) {
        System.out.println("第二层-拦截目标：" + o);
        return Plugin.wrap(o,this);
    }

    // 设置拦截器参数（在配置文件中获取）
    public void setProperties(Properties properties) {
        System.out.println("第二层-拦截器参数加载中 " + properties.toString());
    }
}
