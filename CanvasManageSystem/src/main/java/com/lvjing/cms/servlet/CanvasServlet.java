package com.lvjing.cms.servlet;

import com.lvjing.cms.entity.Canvas;
import com.lvjing.cms.service.CanvasService;
import com.lvjing.cms.util.Requestutil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * 管理油画的servlet
 */
@WebServlet(urlPatterns = {"/manageCanvas.do","/manageCanvasOfCategory.do","/showCanvasDetail.do","/getSmallImg.do","/addCanvasPrompt.do","/addCanvas.do","/updateCanvasPrompt.do","/updateCanvas.do","/delCanvas.do"})
public class CanvasServlet extends HttpServlet {

    private CanvasService canvasService;

    @Override
    public void init() throws ServletException {
        super.init();
        canvasService = CanvasService.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/manageCanvas.do",request.getServletPath())) {
            // 获取油画
            try {
                int pagination = 12;   // 设置每页显示的记录数

                String currentPage = request.getParameter("currentPage");  // 获取当前页
                int page = (currentPage != null && !currentPage.equals("")) ? Integer.parseInt(currentPage) : 1;  // 设置当前页

                int totalRecords = canvasService.countCanvas();  // 数据库中的总记录数
                int totalPage = (totalRecords%pagination == 0) ? totalRecords/pagination : (totalRecords/pagination + 1);  // 设置总页数

                List<Canvas> canvasList = canvasService.pagingForCanvas(((page - 1) * pagination),pagination);  // 获取分页的记录

                request.setAttribute("currentPage",page);
                request.setAttribute("totalPage",totalPage);
                request.setAttribute("canvasList",canvasList);
                request.getRequestDispatcher("/WEB-INF/views/biz/canvas_list.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/biz/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/manageCanvasOfCategory.do",request.getServletPath())) {
            // 获取某一分类下的油画
            try {
                int pagination = 10;   // 设置每页显示的记录数

                String categoryId = request.getParameter("categoryId");    // 获取分类id
                String currentPage = request.getParameter("currentPage");  // 获取当前页
                int page = (currentPage != null && !currentPage.equals("")) ? Integer.parseInt(currentPage) : 1;  // 设置当前页

                int totalRecords = canvasService.countCanvasOfCategory(Integer.parseInt(categoryId));  // 数据库中该油画分类的总记录数
                int totalPage = (totalRecords%pagination == 0) ? totalRecords/pagination : (totalRecords/pagination + 1);  // 设置总页数

                List<Canvas> canvasList = canvasService.pagingForCanvasOfCategory(Integer.parseInt(categoryId), ((page - 1) * pagination), pagination);   // 获取分页的记录

                request.setAttribute("currentPage",page);
                request.setAttribute("totalPage",totalPage);
                request.setAttribute("canvasList",canvasList);
                request.setAttribute("categoryId",categoryId);
                request.getRequestDispatcher("/WEB-INF/views/biz/canvas_under_category_list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/showCanvasDetail.do",request.getServletPath())) {
            // 获取油画的详细信息
            try {
                String id = request.getParameter("id");
                List<Canvas> canvasList = canvasService.findCanvas(new Canvas(Integer.parseInt(id)));
                if (canvasList.size() != 0) {
                    Canvas canvas = canvasList.get(0);
                    canvas.setDetails(canvas.getDetails().replace("\r\n","</p><p>"));  // 分段显示每一个段落
                    request.setAttribute("canvas",canvas);
                    request.getRequestDispatcher("/WEB-INF/views/biz/detail.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/getSmallImg.do",request.getServletPath())) {
            // 获取油画的图片
            try {
                String id = request.getParameter("id");
                Canvas canvas = canvasService.getSmallImg(Integer.parseInt(id));
                if (canvas!=null) {
                    byte[] smallImg = canvas.getSmallImg();
                    if (smallImg.length != 0) {
                        response.setContentType("multipart/form-data");
                        ServletOutputStream os = response.getOutputStream();
                        InputStream is = new ByteArrayInputStream(smallImg);

                        byte[] b = new byte[1024];
                        int len = is.read(b);
                        while (len != -1) {
                            os.write(b);
                            len = is.read(b);
                        }
                        os.flush();
                        is.close();
                        os.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        }  else if (Objects.equals("/addCanvasPrompt.do",request.getServletPath())) {
            // 跳转到新增油画页面
            request.getRequestDispatcher("/WEB-INF/views/biz/add_canvas.jsp").forward(request,response);
        } else if (Objects.equals("/addCanvas.do",request.getServletPath())) {
            // 新增油画
            try {
                Canvas canvas = Requestutil.parseRequest(request);
                canvasService.addCanvas(canvas);
                response.sendRedirect(request.getContextPath()+"/manageCanvas.do");
            } catch (Exception e){
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/updateCanvasPrompt.do",request.getServletPath())) {
            // 编辑油画
            try {
                String id = request.getParameter("id");
                List<Canvas> canvasList = canvasService.findCanvas(new Canvas(Integer.parseInt(id)));
                request.setAttribute("canvas",canvasList.get(0));
                request.getRequestDispatcher("/WEB-INF/views/biz/update_canvas.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/updateCanvas.do",request.getServletPath())) {
            // 修改油画
            try {
                Canvas canvas = Requestutil.parseRequest(request);
                canvasService.updateCanvas(canvas);
                response.sendRedirect(request.getContextPath()+"/manageCanvas.do");
            } catch (Exception e){
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request,response);
            }
        } else if (Objects.equals("/delCanvas.do",request.getServletPath())) {
            // 删除油画
            try {
                String id = request.getParameter("id");
                canvasService.deleteCanvas(Integer.parseInt(id));
                response.sendRedirect(request.getContextPath()+"/manageCanvas.do");
            } catch (Exception e) {
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
