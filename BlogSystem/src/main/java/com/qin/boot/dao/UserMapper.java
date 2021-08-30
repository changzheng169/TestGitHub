package com.qin.boot.dao;
import com.qin.boot.entity.Article;
import com.qin.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //检查用户登录是否正确
    User examLoginIn(@Param("username")String username,@Param("password") String password);
    //插入新用户
    int addUser(User user);
    //删除用户所有博客
    int deleteUserAllArticles(@Param("id") int id);
    //修改用户账号密码
    int updateUser(User user);
    //通过id查询用户
    User queryUserById(@Param("id") int id);
    //通过用户名查询博客
    User queryUserByName(@Param("username") String username);
    //查询用户所有博客信息
    List<Article> queryAllArticles(@Param("userId") int userId);

}
