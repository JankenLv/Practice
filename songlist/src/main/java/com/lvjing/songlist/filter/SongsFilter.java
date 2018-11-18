package com.lvjing.songlist.filter;

import com.lvjing.songlist.entity.Song;
import com.lvjing.songlist.service.SongService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

/**
 * 拦截home.jsp
 * 进入home.jsp前获取所有歌曲作为参数传递过去
 */
@WebFilter(
        urlPatterns = "/WEB-INF/views/biz/home.jsp",
        dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class SongsFilter implements Filter {

    private SongService songService;

    public void init(FilterConfig filterConfig) throws ServletException {
        songService = SongService.getInstance();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<Song> songs = songService.getSongs();
        servletRequest.setAttribute("songs",songs);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
