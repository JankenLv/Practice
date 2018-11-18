package com.lvjing.bm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lvjing.bm.entity.Book;
import com.lvjing.bm.entity.Category;
import com.lvjing.bm.service.BookService;
import com.lvjing.bm.service.CategoryService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller("bookController")
@MultipartConfig
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    //      /book/main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("list.do");
    }

    //      /book/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getBooks(request,response);
    }

    //      /book/subList.do
    public void subList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getBooks(request,response);
    }

    //      /book/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> subList = categoryService.getAll();
        request.setAttribute("SubList",subList);
        request.getRequestDispatcher("/WEB-INF/views/biz/add_book.jsp").forward(request,response);
    }

    //      /book/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = parseRequest(request, new Book());
        bookService.add(bookList);
        response.sendRedirect("list.do");
    }

    //      /book/toModify.do
    public void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Book book = bookService.getById(id);
        List<Category> subList = categoryService.getAll();
        request.setAttribute("SubList",subList);
        request.setAttribute("Book",book);
        request.getRequestDispatcher("/WEB-INF/views/biz/edit_book.jsp").forward(request,response);
    }

    //      /book/modify.do
    public void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Book book = bookService.getById(Integer.valueOf(id));
            List<Book> bookList = parseRequest(request,book);
            bookService.modify(bookList.get(0));
            response.sendRedirect("list.do");
        }
    }


    //      /book/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Book book = bookService.getById(id);
        String path = book.getImgPath();
        if (!StringUtils.isEmpty(path)) {
            delPicture(path,request);
        }
        bookService.remove(id);
        response.sendRedirect("list.do");
    }

    /**
     * 解析request，获取表单项和上传的文件
     * @param request request请求
     * @param book    Book对象
     * @return        保存Book对象的集合
     */
    private List<Book> parseRequest(HttpServletRequest request,Book book) {
        int i = 1;
        List<Book> bookList = new ArrayList<>();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    switch (fileItem.getFieldName()) {
                        case "name":
                            String name = fileItem.getString("UTF-8");
                            if (!StringUtils.isEmpty(name)) {
                                book.setName(name);
                            }
                            break;
                        case "categoryId":
                            String categoryId = fileItem.getString("UTF-8");
                            if (!StringUtils.isEmpty(categoryId)) {
                                book.setCategoryId(Integer.valueOf(categoryId));
                            }
                            break;
                        case "level":
                            String level = fileItem.getString("UTF-8");
                            if (!StringUtils.isEmpty(level)) {
                                book.setLevel(Integer.valueOf(level));
                            }
                            break;
                        case "price":
                            String price = fileItem.getString("UTF-8");
                            if (!StringUtils.isEmpty(price)) {
                                book.setPrice(Integer.valueOf(price));
                            }
                            break;
                    }
                } else {
                    try {
                        String name = fileItem.getName();
                        if (!StringUtils.isEmpty(name)) {

                            // 更新图片前先把旧的图片删除
                            String path = book.getImgPath();
                            if (!StringUtils.isEmpty(path)) {
                                delPicture(path,request);
                            }

                            // 更新图片
                            String suffix = name.substring(name.lastIndexOf("."));
                            String prefix = UUID.randomUUID().toString().replace("-","");
                            String fileName = prefix + suffix;
                            String realPath = request.getServletContext().getRealPath("/upload");

                            File file = new File(realPath);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            String imgPath = realPath + File.separator + fileName;

                            InputStream is = fileItem.getInputStream();
                            FileOutputStream os = new FileOutputStream(imgPath);
                            byte[] b = new byte[1024];
                            int len = -1;
                            while ((len=is.read(b)) != -1) {
                                os.write(b);
                            }
                            os.flush();
                            is.close();
                            os.close();

                            book.setImgPath(imgPath);
                            System.out.println("图片保存路径：" + imgPath);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                // i==5代表已经解析完了一个Book对象的数据
                if (i == 5) {
                    bookList.add(book);
                    book = new Book();
                    i = 0;
                }
                i++;
            }
        } catch (FileUploadException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    /**
     * 查询图书（查询所有或根据分类ID查询），并把查询结果传递到前端页面
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     */
    private void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取及设置分类ID
        Integer catId = -1;
        if (!StringUtils.isEmpty(request.getParameter("catId"))) {
            catId = Integer.valueOf(request.getParameter("catId"));
        }

        // 获取及设置页码
        int currentPage = 1;
        String page = request.getParameter("page");
        if (!StringUtils.isEmpty(page)) {
            currentPage = Integer.parseInt(page);
        }

        // 使用PageHelper分页
        String pageSize = request.getServletContext().getInitParameter("pageSize");
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

        List<Category> subList = categoryService.getAll();
        request.setAttribute("PageInfo",pageInfo);
        request.setAttribute("CatId",catId);
        request.setAttribute("SubList",subList);
        request.getRequestDispatcher("/WEB-INF/views/biz/book_list.jsp").forward(request,response);
    }

    /**
     * 删除保存在磁盘的图片
     * @param imgPath  图片路径
     */
    private void delPicture(String imgPath,HttpServletRequest request) {
        String realPath = request.getServletContext().getRealPath("/upload");
        String separator = imgPath.contains("/") ? "/" : "\\";
        String imgName = imgPath.substring(imgPath.lastIndexOf(separator)+1);
        String img = realPath + File.separator + imgName;
        File file = new File(img);
        if (file.getParentFile().exists()) {
            System.out.println(file.delete() ? "<<<========图片删除成功========>>>" : "<<<========图片不存在========>>>");
        }
    }

}
