package com.qin.boot.service.impl;

import com.qin.boot.dao.UserDao;
import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(String username,String password){
        return userDao.findUser(username,password);
    }
}
