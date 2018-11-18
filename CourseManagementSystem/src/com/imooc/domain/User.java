package com.imooc.domain;

public class User {
    private String username;
    private String password;
    private String authority;

    public User(){
        this.authority = "普通管理员";
    }

    public User(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
