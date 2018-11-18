package com.lvjing.cms.filter;

import com.lvjing.cms.entity.Canvas;
import com.lvjing.cms.service.CanvasService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 获取油画，传递到下一个页面的filter
 */
@WebFilter(urlPatterns = {"/WEB-INF/views/biz/home.jsp"},dispatcherTypes = DispatcherType.FORWARD)
public class CanvasFilter implements Filter {

    private CanvasService canvasService;

    @Override
    public void init(FilterConfig filterConfig) {
        canvasService = CanvasService.getInstance();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {
            int pagination = 9;   // 设置每页显示的记录数

            String currentPage = request.getParameter("currentPage");  // 获取当前页
            int page = (currentPage != null && !currentPage.equals("")) ? Integer.parseInt(currentPage) : 1;  // 设置当前页

            String totalPage = request.getParameter("totalPage");   // 获取总页数
            if (totalPage == null || totalPage.equals("")) {
                int totalRecords = canvasService.countCanvas();  // 数据库中的总记录数
                totalPage = String.valueOf((totalRecords%pagination == 0) ? totalRecords/pagination : (totalRecords/pagination + 1));  // 设置总页数
            }

            List<Canvas> canvasList = canvasService.pagingForCanvas(((page - 1) * pagination),pagination);  // 获取分页的记录

            request.setAttribute("currentPage",page);
            request.setAttribute("totalPage",totalPage);
            request.setAttribute("canvasList",canvasList);
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
            servletRequest.getRequestDispatcher("/WEB-INF/views/error/500.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
