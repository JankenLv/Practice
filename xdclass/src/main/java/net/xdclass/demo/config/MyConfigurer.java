package net.xdclass.demo.config;

import net.xdclass.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置类，注册自定义拦截器
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/4 22:26 </p>
 */
@Configuration
public class MyConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/v1/interceptor/**");
    }
}
