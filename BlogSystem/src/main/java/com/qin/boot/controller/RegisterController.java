package com.qin.boot.controller;

import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 注册
 */
@Controller
public class RegisterController {
    @Autowired
    UserService userService;
    /**
     * 将用户注册进入数据库中，若id值或用户名已被占用，则重新注册
     * @return 返回登录页面
     * @param user 用户
     */
    @PostMapping("/register")
    public String registerUser(User user, Model model){
       if(userService.queryUserById(user.getUserId())==null){
           if(userService.queryUserByName(user.getUsername())==null){
               userService.addUser(user);
               return "redirect:/login";
           }
           model.addAttribute("msg","该用户名已被注册");
           return "register";
       }
       model.addAttribute("msg","该id已被注册");
       return "register";
    }
}
