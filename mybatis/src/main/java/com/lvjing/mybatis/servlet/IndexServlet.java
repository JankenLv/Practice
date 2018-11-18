package com.lvjing.mybatis.servlet;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lvjing.mybatis.bean.Person;
import com.lvjing.mybatis.dao.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    private void initSessionFactory() {
        String resource = "mybatis-config.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        if (sqlSession != null) {
            sqlSession.close();
        }
        sqlSession = null;
        sqlSessionFactory = null;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        initSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("pageNum");
        Integer pageNum = parameter != null && !parameter.equals("") ? Integer.parseInt(parameter)  : 1;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<Person> list = mapper.selectAll();
        PageInfo<Object> pageInfo = page.toPageInfo();

        request.setAttribute("LIST",page);
        request.setAttribute("PageInfo",pageInfo);
        request.getRequestDispatcher("person_list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        close();
    }
}
