package com.webflux.demo.model;

/**
 * 功能描述：user数据模型
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/12/11 22:05 </p>
 */
public class User {

    private String id;

    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
