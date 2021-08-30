package com.qin.boot.service;
import com.qin.boot.entity.Article;
import com.qin.boot.entity.User;


import java.util.List;


public interface UserService {
    //插入新用户
    int addUser(User user);
    //删除用户,以及博客
    int deleteUserAllArticles(int id);
    //修改用户密码
    int updateUser(User user);
    //通过id查询用户
    User queryUserById(int id);
    //通过用户名查询用户
    User queryUserByName(String username);
    //检查登录
    User examLoginIn(String username,String password);
    //查询用户所有博客信息
    List<Article> queryAllArticles(int userId);


}
