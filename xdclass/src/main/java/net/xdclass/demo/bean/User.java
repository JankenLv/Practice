package net.xdclass.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {

    @JsonProperty("account")
    private String name;

    @JsonIgnore
    private String pwd;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date loginTime;

    public User() {

    }

    public User( String name, String phone, Date date) {
        this.name = name;
        this.phone = phone;
        this.loginTime = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
