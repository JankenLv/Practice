package com.lvjing.songlist.mapper;

import com.lvjing.songlist.entity.Picture;
import com.lvjing.songlist.entity.Song;
import com.lvjing.songlist.entity.SongList;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 映射器接口
 */
public interface SongMapper {

    /**
     * 获取所有歌曲
     * @return 所有歌曲
     */
    @Select("select * from mytest.song")
    @Results(value = {
        @Result(column = "issudata",property = "issudate")
    })
    List<Song> getAllSong();

    /**
     * 获取登录用户的歌单
     * @return 歌单
     */
    @Select("select * from mytest.songlist where creator = #{username}")
    @Results(value = {
        @Result(property = "songName",column = "songname")
    })
    List<SongList> getSongList(String username);


    /**
     * 获取登录用户的歌单
     * @return 歌单
     */
    @Insert("insert into mytest.songlist(name,creator,description)" +
            "values(#{name},#{creator},#{description})")
    @SelectKey(before = false,resultType = int.class,keyColumn = "id",keyProperty = "id",statement = "select LAST_INSERT_ID()")
    int createSongList(SongList songList);


    /**
     * 保存图片到数据库（测试）
     */
    @Insert("insert into mytest.pic values(#{id},#{picture})")
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty = "id",before = false,keyColumn = "id",resultType = int.class)
    int savePicture(Picture picture);

    /**
     * 把数据库中保存的图片读取出来
     */
    @Select("select picture from mytest.pic where id = #{id}")
    Picture getPicture(int id);

}
