package com.lvjing.songlist.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 编码过滤器
 */
@WebFilter("/*")
public class EncodeFilter implements Filter {

    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
//        encoding = filterConfig.getInitParameter("encoding");
        encoding = "UTF-8";
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        encoding = null;
    }
}
