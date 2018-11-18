package com.lvjing.songlist.servlet;

import com.google.common.base.Objects;
import com.lvjing.songlist.entity.SongList;
import com.lvjing.songlist.service.SongService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 获取登录用户歌单的servlet
 */
@WebServlet(urlPatterns = {"/createSongListPrompt","/createSongList","/mySongList"})
public class SongListServlet extends HttpServlet {

    private SongService songService;

    @Override
    public void init() throws ServletException {
        super.init();
        songService = SongService.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equal("/createSongListPrompt",request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/createSongList.jsp").forward(request, response);
        } else if (Objects.equal("/createSongList",request.getServletPath())) {
            String username = (String) request.getSession().getAttribute("username");
            if (username != null) {
                String songListName = request.getParameter("songListName");
                String songListDesp = request.getParameter("songListDesp");
                if (!(songListName.equals("")&&songListDesp.equals(""))) {
                    int result = songService.createSongList(new SongList(songListName,username,songListDesp));
                    if (result>0) {
                        response.sendRedirect(request.getContextPath()+"/mySongList");
                    }else {
                        System.out.println("创建歌单失败。");
                        request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request, response);
                    }
                }
            } else {
                System.out.println("username为空，中断操作。");
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request, response);
            }

        } else if (Objects.equal("/mySongList", request.getServletPath())) {
            String username = (String) request.getSession().getAttribute("username");
            if (username != null) {
                List<SongList> songList = songService.getSongList(username);
                request.setAttribute("songLists", songList);
                request.getRequestDispatcher("/WEB-INF/views/biz/songList.jsp").forward(request, response);
            } else {
                System.out.println("username为空，中断操作。");
                request.getRequestDispatcher("/WEB-INF/views/error/500.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
        }
    }


    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        SongList songList = songService.getSongList(username);
        request.setAttribute("songList",songList);
        request.getRequestDispatcher("/WEB-INF/views/biz/songList.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }*/
}
