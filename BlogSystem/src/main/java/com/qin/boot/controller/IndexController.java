package com.qin.boot.controller;

import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 登录页面
 */
@Controller
public class IndexController {
    @Autowired
    UserService userService;
    /**
     * 跳转到登录的表单页面
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage(){
        return "login";
    }

    /**
     * 检查用户密码是否正确,正确就跳转到主页面
     * @return
     * @param username 用户名
     * @param password 密码
     * @param session 添加loginUser对象
     * @param model 在请求域中添加信息
     */
    @PostMapping("/login")
    public String examUser(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpSession session,
                           Model model){
        User user = userService.examLoginIn(username, password);
        System.out.println(user);
        if(user!=null) {
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账号或密码错误！");
        return "login";
    }

    /**
     * 跳转到主页面
     * @return
     */
    @GetMapping("main.html")
    public String homePage(){
        return "main";
    }
    /**
     * 跳转注册页面
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
