package com.lvjing.cms.entity;

import java.util.Date;

public class Category {

    private Integer id;
    private String  name;
    private String  createName;
    private Date    createTime;
    private Date    updateTime;
    private String  description;

    public Category() {
    }

    public Category(int id, String name, String createName, String description) {
        this.id = id;
        this.name = name;
        this.createName = createName;
        this.description = description;
    }

    public Category(String name, String createName, Date createTime, String description) {
        this.name = name;
        this.createName = createName;
        this.createTime = createTime;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createName='" + createName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
