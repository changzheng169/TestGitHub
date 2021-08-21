package com.qin.boot.service;

import com.qin.boot.entity.User;

public interface UserService {
    public User getUser(String username,String password);
}
