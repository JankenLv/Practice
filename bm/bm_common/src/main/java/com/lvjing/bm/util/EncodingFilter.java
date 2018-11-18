package com.lvjing.bm.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤器（默认编码为：UTF-8）
 */
public class EncodingFilter implements Filter {

    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        // 默认编码为：UTF-8
        encoding = "UTF-8";
        String initEncoding = filterConfig.getInitParameter("Encoding");
        if (initEncoding != null) {
            encoding = initEncoding;
        }
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
