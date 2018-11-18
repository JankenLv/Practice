package com.imooc.filter;

import javax.servlet.*;
import java.io.IOException;

public class encodeFilter implements Filter {
    private String encoding;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

    @Override
    public void destroy() {

    }
}
