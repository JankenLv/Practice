package com.imooc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 设置页面编码的过滤器
 */
public class EncodeFilter implements Filter {
    private String encode;

    @Override
    public void init(FilterConfig filterConfig) {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encode);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
