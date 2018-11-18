package net.xdclass.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录过滤器
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/4 10:06 </p>
 */
@WebFilter(urlPatterns = {"/api/user/*"}, filterName = "loginFilter")
public class LoginFilter implements Filter {

    // 容器创建时，初始化filter
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("===>>> login filter has been init ===>>>");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String account = request.getParameter("account");
        if ("jankin_lv".equals(account)) {
            System.out.println("===>>> welcome, " + account + "! ===>>>");
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect("/illegal.html");
        }
    }

    @Override
    public void destroy() {
        System.out.println("===>>> login filter has been destroy ===>>>");
    }
}
