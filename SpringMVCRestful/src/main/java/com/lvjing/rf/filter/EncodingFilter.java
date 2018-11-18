package com.lvjing.rf.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤器（默认编码：UTF-8）
 */
public class EncodingFilter implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = "UTF-8";
        if (filterConfig.getInitParameter("Encoding")!=null) {
            encoding = filterConfig.getInitParameter("Encoding");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
