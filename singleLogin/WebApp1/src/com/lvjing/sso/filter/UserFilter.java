package com.lvjing.sso.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UserFilter implements Filter {

    private String server;
    private String app;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        server = filterConfig.getInitParameter("server");
        app = filterConfig.getInitParameter("app");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String ticket = null;
        if (null != ((HttpServletRequest)request).getCookies()) {
            for(Cookie cookie : ((HttpServletRequest)request).getCookies()) {
                if (Objects.equals(cookie.getName(),"Ticket_Granting_Ticket")) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }

        if (!Objects.equals(null,ticket)) {
            // 进行用户校检，如果不是用户或用户非法，跳转到登录页面或者不需要登录的页面
            chain.doFilter(request,response);
            return;
        }

        ticket = request.getParameter("ticket");
        if (!Objects.equals(null, ticket) && !Objects.equals("", ticket.trim())) {
            ((HttpServletResponse) response).addCookie(new Cookie("Ticket_Granting_Ticket", ticket));
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(server + "/ssoLogin?source=" + app);
        }
    }
}
