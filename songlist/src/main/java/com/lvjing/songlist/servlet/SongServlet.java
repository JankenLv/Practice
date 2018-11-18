package com.lvjing.songlist.servlet;

import com.google.common.base.Objects;
import com.lvjing.songlist.entity.Song;
import com.lvjing.songlist.service.SongService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/getSongs","/home"})
public class SongServlet extends HttpServlet {

    private SongService songService;

    @Override
    public void init() throws ServletException {
        super.init();
        songService = SongService.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equal("/home",request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/home.jsp").forward(request,response);
        } else if (Objects.equal("/getSongs", request.getServletPath())) {
            List<Song> songs = songService.getSongs();
            request.setAttribute("songs", songs);
            request.getRequestDispatcher("/WEB-INF/views/biz/home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
        }
    }

    /* @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Song> songs = songService.getSongs();
        request.setAttribute("songs",songs);
        request.getRequestDispatcher("/WEB-INF/views/biz/home.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }*/

    @Override
    public void destroy() {
        super.destroy();
//        songService = SongService.getInstance();
    }


}
