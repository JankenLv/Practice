package com.lvjing.cms.filter;

import com.lvjing.cms.entity.Category;
import com.lvjing.cms.service.CategoryService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.util.List;

/**
 * 获取油画分类，传递到下一个页面的filter
 */
@WebFilter(urlPatterns = {"/WEB-INF/views/biz/add_canvas.jsp","/WEB-INF/views/biz/update_canvas.jsp",
"/WEB-INF/views/biz/canvas_list.jsp","/WEB-INF/views/biz/canvas_under_category_list.jsp"},dispatcherTypes = DispatcherType.FORWARD)
public class CategoryFilter implements Filter {

    private CategoryService categoryService;

    @Override
    public void init(FilterConfig filterConfig) {
        categoryService = CategoryService.getInstance();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try {
            List<Category> categories = categoryService.getCategoryNameAndId();
            servletRequest.setAttribute("categories",categories);
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
