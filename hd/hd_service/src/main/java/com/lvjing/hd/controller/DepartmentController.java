package com.lvjing.hd.controller;

import com.lvjing.hd.entity.Category;
import com.lvjing.hd.entity.Department;
import com.lvjing.hd.service.CategoryService;
import com.lvjing.hd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("deptController")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CategoryService categoryService;

    //    /dept/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        List<Category> subList = categoryService.getAll();
        request.setAttribute("SUBLIST",subList);
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("/WEB-INF/views/biz/department_list.jsp").forward(request,response);
    }

    //    /dept/subList.do
    public void subList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer catId = Integer.valueOf(request.getParameter("id"));
        List<Department> list = departmentService.getByCatId(catId);
        List<Category> subList = categoryService.getAll();
        request.setAttribute("LIST",list);
        request.setAttribute("SUBLIST",subList);
        request.getRequestDispatcher("/WEB-INF/views/biz/department_list.jsp").forward(request,response);
    }

    //    /dept/toModify.do
    public void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Department dep = departmentService.getById(id);
        List<Category> subList = categoryService.getAll();
        request.setAttribute("DEP",dep);
        request.setAttribute("SUBLIST",subList);
        request.getRequestDispatcher("/WEB-INF/views/biz/department_modify.jsp").forward(request,response);
    }

    //    /dept/modify.do
    public void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer catId = Integer.valueOf(request.getParameter("category"));
        Department dep = departmentService.getById(id);
        dep.setCategoryId(catId);
        dep.setName(name);
        departmentService.modify(dep);
        response.sendRedirect("list.do");
    }

    //    /dept/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> subList = categoryService.getAll();
        request.setAttribute("SUBLIST",subList);
        request.getRequestDispatcher("/WEB-INF/views/biz/department_add.jsp").forward(request,response);
    }

    //    /dept/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer catId = Integer.valueOf(request.getParameter("category"));
        Department dep = new Department();
        dep.setCategoryId(catId);
        dep.setName(name);
        departmentService.add(dep);
        response.sendRedirect("list.do");
    }

    //    /dept/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        departmentService.remove(id);
        response.sendRedirect("list.do");
    }
}
