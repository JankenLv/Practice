package com.imooc.servlet;

import net.sf.json.JSONArray;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 分页查询的servlet
 */
public class PagingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pages = Integer.parseInt(request.getParameter("page"));
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        JSONArray result = (JSONArray) request.getSession().getAttribute("result");
        JSONArray subResult = null;

        if (pages>0 && currentPage>0) {
            int firstIndex = pages*(currentPage-1);
            int lastIndex = pages*currentPage;
            if (lastIndex > result.size()) {
                lastIndex = result.size();
            }
            subResult = JSONArray.fromObject(result.subList(firstIndex, lastIndex));
        }

        request.getSession().setAttribute("subResult",subResult);
        request.getSession().setAttribute("export","subResult");
//            System.out.println("分页结果：\n" + subResult);

        // 返回分页结果
        response.setContentType("text/json;charset=UTF-8");
        ServletOutputStream os = response.getOutputStream();
        byte[] bytes = Objects.requireNonNull(subResult).toString().getBytes("UTF-8");
        os.write(bytes);
        os.flush();
        os.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }
}
