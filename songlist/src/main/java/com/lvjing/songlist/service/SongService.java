package com.lvjing.songlist.service;

import com.lvjing.songlist.dao.SongDAO;
import com.lvjing.songlist.entity.Picture;
import com.lvjing.songlist.entity.Song;
import com.lvjing.songlist.entity.SongList;

import java.util.List;

public class SongService {

    private static SongService songService;
    private SongDAO songDAO;

    private SongService() {

    }

    public static SongService getInstance() {
        if (songService==null) {
            songService = new SongService();
        }
        return songService;
    }

    private SongDAO getSongDAO() {
        songDAO = new SongDAO();
        return songDAO;
    }

    public List<Song> getSongs() {
        return getSongDAO().getSongs();
    }

    public List<SongList> getSongList(String username) {
        return getSongDAO().getSongList(username);
    }

    public int createSongList(SongList songList) {
        return getSongDAO().createSongList(songList);
    }

    /**
     * 测试保存文件到数据库
     */
    public int savePicture(Picture picture) {
        return getSongDAO().savePicture(picture);
    }

    /**
     * 把数据库中保存的图片读取出来
     */
    public Picture getPicture(int id) {
        return getSongDAO().getPicture(id);
    }

}
