package com.lvjing.songlist.dao;

import com.lvjing.songlist.entity.Picture;
import com.lvjing.songlist.entity.Song;
import com.lvjing.songlist.entity.SongList;
import com.lvjing.songlist.mapper.SongMapper;
import com.lvjing.songlist.util.JDBCUtil;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SongDAO {

    private List<Song> songs;
    private SqlSession sqlSession;
    private SongMapper songMapper;
    private SongList   songList;
    private int        result;
    private List<SongList> songLists;
    private Picture picture;

    private SqlSession getSqlSession() {
        sqlSession = JDBCUtil.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    private SongMapper getSongMapper() {
        songMapper = getSqlSession().getMapper(SongMapper.class);
        return songMapper;
    }

    private void closeSqlSession() {
        if (sqlSession!=null) {
            sqlSession.close();
        }
        sqlSession = null;
    }

    public List<Song> getSongs() {
        try {
            songs = getSongMapper().getAllSong();
        } finally {
            closeSqlSession();
        }
        return songs;
    }

    public List<SongList> getSongList(String username) {
        try {
            songLists = getSongMapper().getSongList(username);
        } finally {
            closeSqlSession();
        }
        return songLists;
    }

    public int createSongList(SongList songList) {
        try {
            result = getSongMapper().createSongList(songList);
            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return result;
    }

    /**
     * 测试保存文件到数据库
     */
    public int savePicture(Picture picture) {
        try {
            result = getSongMapper().savePicture(picture);
            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return result;
    }

    /**
     * 把数据库中保存的图片读取出来
     */
    public Picture getPicture(int id) {
        try {
            picture = getSongMapper().getPicture(id);
        } finally {
            closeSqlSession();
        }
        return picture;
    }

}
