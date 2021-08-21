package com.qin.boot.dao;

import com.qin.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
    public User findUser(@Param("username") String username, @Param("password") String password);
}
