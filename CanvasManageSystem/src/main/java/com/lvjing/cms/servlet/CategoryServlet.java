package com.lvjing.cms.servlet;

import com.lvjing.cms.entity.Category;
import com.lvjing.cms.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 管理油画分类的servlet
 */
@WebServlet(urlPatterns = {"/showAllCategories.do","/addCategoryPrompt.do","/addCategory.do","/updateCategoryPrompt.do","/updateCategory.do","/delCategory.do",})
public class CategoryServlet extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = CategoryService.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/showAllCategories.do",request.getServletPath())) {
            // 获取所有油画分类
            try {
                List<Category> categories = categoryService.getAllCategories();
                request.setAttribute("categories",categories);
                request.getRequestDispatcher("/WEB-INF/views/biz/category_list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/addCategoryPrompt.do",request.getServletPath())) {
            // 跳转到添加油画分类页面
            request.getRequestDispatcher("/WEB-INF/views/biz/add_category.jsp").forward(request,response);
        } else if (Objects.equals("/addCategory.do",request.getServletPath())) {
            // 新增油画分类
            try {
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String username = (String) request.getSession().getAttribute("username");
                categoryService.addCategory(new Category(name,username,new Date(),description));
                response.sendRedirect(request.getContextPath() + "/showAllCategories.do");
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/updateCategoryPrompt.do",request.getServletPath())) {
            // 编辑油画分类
            try {
                String id = request.getParameter("id");
                Category category = categoryService.getCategoryById(Integer.parseInt(id));
                request.setAttribute("category",category);
                request.getRequestDispatcher("/WEB-INF/views/biz/update_category.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/updateCategory.do",request.getServletPath())) {
            // 修改油画分类
            try {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String username = (String) request.getSession().getAttribute("username");
                categoryService.updateCategory(new Category(Integer.parseInt(id),name,username,description));
                response.sendRedirect(request.getContextPath()+"/showAllCategories.do");
            } catch (Exception e){
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/delCategory.do",request.getServletPath())) {
            // 删除油画分类
            try {
                String id = request.getParameter("id");
                categoryService.delCategory(Integer.parseInt(id));
                response.sendRedirect(request.getContextPath()+"/showAllCategories.do");
            } catch (Exception e){
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
