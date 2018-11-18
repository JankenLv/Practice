package com.lvjing.hd.controller;

import com.lvjing.hd.entity.Category;
import com.lvjing.hd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    //   /category/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("/WEB-INF/views/biz/category_list.jsp").forward(request,response);
    }

    //   /category/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/category_add.jsp").forward(request,response);
    }

    //   /category/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);
        Category result = categoryService.get(category);
        if (result == null) {
            categoryService.add(category);
            response.sendRedirect("list.do");
        } else {
            response.setContentType("text/html;charset=utf8");
            PrintWriter writer = response.getWriter();
            writer.print("<script type='text/javascript'>alert('科室分类已存在，请不要重复添加！');window.history.back();</script>");
        }
    }

    //   /category/toModify.do
    public void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Category category = categoryService.get(new Category(id));
        request.setAttribute("Category",category);
        request.getRequestDispatcher("/WEB-INF/views/biz/category_modify.jsp").forward(request,response);
    }

    //   /category/modify.do
    public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);
        category.setId(id);
        categoryService.modify(category);
        response.sendRedirect("list.do");
    }


    //   /category/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        categoryService.remove(id);
        response.sendRedirect("list.do");
    }
}
