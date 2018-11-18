package com.lvjing.bm.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lvjing.bm.entity.Book;
import com.lvjing.bm.entity.Category;
import com.lvjing.bm.service.BookService;
import com.lvjing.bm.service.CategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * 默认servlet
 */
public class BookServlet extends HttpServlet {

    private ApplicationContext context;

    private BookService bookService;

    private CategoryService categoryService;

    private String imgPath;

    private String managePath;

    private String pageSize;

    @Override
    public void init(ServletConfig servletConfig) {
        context = new ClassPathXmlApplicationContext("spring.xml");
        bookService = (BookService) context.getBean("bookService");
        categoryService = (CategoryService) context.getBean("categoryService");

        // 图片保存的路径
        imgPath = servletConfig.getServletContext().getInitParameter("imgPath");
        // 进入后台管理系统的路径
        managePath = servletConfig.getServletContext().getInitParameter("manage");
        // 设置分页大小
        pageSize = servletConfig.getServletContext().getInitParameter("pageSize");

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Objects.equals("/list.do",request.getServletPath())) {
            queryHandler(request,response);
        } else if (Objects.equals("/subList.do",request.getServletPath())) {
            queryHandler(request,response);
        } else if (Objects.equals("/manage.do", request.getServletPath())) {
            response.sendRedirect(managePath);
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        context = null;
        bookService = null;
        categoryService = null;
    }

    /**
     * 查询图书（查询全部或根据分类ID查询），并把查询结果传递到前端页面
     * @param request    HttpServletRequest
     * @param response   HttpServletResponse
     */
    private void queryHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置分类ID
        Integer catId = -1;
        if (!StringUtils.isEmpty(request.getParameter("catId"))) {
            catId = Integer.valueOf(request.getParameter("catId"));
        }

        // 设置当前页
        int currentPage = 1;
        String page = request.getParameter("page");
        if (!StringUtils.isEmpty(page)) {
            currentPage = Integer.parseInt(page);
        }

        // 使用PageHelper分页（默认分页大小为：8）
        Integer size = StringUtils.isEmpty(pageSize) ? 8 : Integer.valueOf(pageSize);
        Integer finalCatId = catId;
        PageInfo<Book> pageInfo;
        if (catId == -1) {
            // 查询所有图书
            pageInfo = PageHelper.startPage(currentPage, size).doSelectPageInfo(() -> bookService.getAll());
        } else {
            // 查询某一分类下的图书
            pageInfo = PageHelper.startPage(currentPage, size).doSelectPageInfo(() -> bookService.getByCatId(finalCatId));
        }

        // 设置图片路径
        List<Book> list = pageInfo.getList();
        for (Book book : list) {
            String path = book.getImgPath();
            if (!StringUtils.isEmpty(path)) {
                String separator = path.contains("/") ? "/" : "\\";
                String imgName = path.substring(path.lastIndexOf(separator) + 1);
                book.setImgPath(imgPath + imgName);
            } else {
                book.setImgPath(null);
            }
        }

        List<Category> subList = categoryService.getAll();
        request.setAttribute("PageInfo",pageInfo);
        request.setAttribute("List",list);
        request.setAttribute("SubList",subList);
        request.setAttribute("CatId",catId);
        request.getRequestDispatcher("/WEB-INF/views/biz/home.jsp").forward(request,response);
    }
}
