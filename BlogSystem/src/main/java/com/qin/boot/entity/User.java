package com.qin.boot.entity;



/**
 * @description:博客用户类
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private String introduction;

    public User() {
    }

    public User(int userId, String username, String password, String introduction) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.introduction = introduction;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
