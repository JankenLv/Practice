package com.ljs.ssp.domain;

import java.util.Date;

/**
 * 功能描述：用户
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 23:45 </p>
 */
public class User {

    private Integer age;

    private String pwd;

    private String phone;

    private Date createTime;

    public Integer getAge() {
        return age;
    }

    public User() {
    }

    public User(Integer age, String pwd, String phone, Date createTime) {
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
