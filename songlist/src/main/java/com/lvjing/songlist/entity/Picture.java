package com.lvjing.songlist.entity;

public class Picture {

    private Integer id;
    private byte[]  picture;


    public Picture() {
    }

    public Picture(byte[] picture) {
        this.picture = picture;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
