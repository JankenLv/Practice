package net.xdclass.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/4 22:32 </p>
 */
public class MyInterceptor implements HandlerInterceptor {

    /* 调用Controller某个方法之前 */
    /* 如果返回值不是'true'，后续操作都会被禁止 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入controller之前拦截 ---> preHandle");

        /* 如果返回值不是'true'，后续操作都会被禁止 */
        return true;
    }

    /* Controller之后调用，视图渲染之前，如果控制器Controller出现了异常，则不会执行此方法 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("controller调用后拦截 ---> postHandle");
    }

    /* 不管有没有异常，这个afterCompletion都会被调用，用于资源清理 */
    /* 前提是请求被'preHandle'方法放行，否则不会被调用*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("不管发生了什么，我都会被调用 ---> afterCompletion");
    }
}
