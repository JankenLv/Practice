package com.lvjing.bm.controller;

import com.lvjing.bm.entity.Category;
import com.lvjing.bm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller("categoryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //     /category/main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("list.do");
    }

    //     /category/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.getAll();
        request.setAttribute("List",list);
        request.getRequestDispatcher("/WEB-INF/views/biz/category_list.jsp").forward(request,response);
    }

    //     /category/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/add_category.jsp").forward(request,response);
    }

    //     /category/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (!StringUtils.isEmpty(name)) {
            Category category = new Category();
            category.setName(name);
            categoryService.add(category);
            response.sendRedirect("list.do");
        } else {
            response.setContentType("text/html;charset=utf8");
            PrintWriter writer = response.getWriter();
            writer.print("<script type='text/javascript'>alert('分类名称不能为空！');window.history.back();</script>");
        }
    }

    //     /category/toModify.do
    public void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Category category = categoryService.getById(id);
        request.setAttribute("Category",category);
        request.getRequestDispatcher("/WEB-INF/views/biz/edit_category.jsp").forward(request,response);
    }

    //     /category/modify.do
    public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = categoryService.getById(id);
        category.setName(name);
        categoryService.modify(category);
        response.sendRedirect("list.do");
    }

    //     /category/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        categoryService.remove(id);
        response.sendRedirect("list.do");
    }

}
