package com.qin.boot.service.impl;

import com.qin.boot.dao.UserMapper;
import com.qin.boot.entity.Article;
import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper  userMapper;
    @Override
    public int addUser(User user) {
         return userMapper.addUser(user);
    }
    @Override
    public int deleteUserAllArticles(int id) {
        return  userMapper.deleteUserAllArticles(id);

    }
    @Override
    public int updateUser(User user) {
        return  userMapper.updateUser(user);

    }
    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User examLoginIn(String username, String password) {
        return userMapper.examLoginIn(username,password);
    }
    @Override
    public User queryUserByName(String username) {
       return userMapper.queryUserByName(username);
    }
    @Override
    public List<Article> queryAllArticles(int userId) {
        return userMapper.queryAllArticles(userId);
    }
}
