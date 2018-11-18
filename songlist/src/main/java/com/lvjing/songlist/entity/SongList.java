package com.lvjing.songlist.entity;

public class SongList {

    private Integer id;
    private String  name;
    private String  songName;
    private String  creator;
    private String  description;

    public SongList() {
    }

    public SongList(String songListName, String creator, String description) {
        this.name = songListName;
        this.creator = creator;
        this.description = description;
    }

    @Override
    public String toString() {
        return "SongList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songName='" + songName + '\'' +
                ", creator='" + creator + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
