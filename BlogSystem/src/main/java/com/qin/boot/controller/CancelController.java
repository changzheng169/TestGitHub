package com.qin.boot.controller;

import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * 删除所有博客内容
 */
@Controller
public class CancelController {
    @Autowired
    UserService userService;
    /**
     * @return 跳转到删除页面
     */
    @GetMapping("/cancel")
    public String cancelPage(){
      return "/cancel";
    }

    /**
     * @param user 用户类
     * @param session 提供loginUser对象
     * @param model 在请求域中添加信息
     * @return 返回页面
     */
    @PostMapping("/cancel")
    public String cancelUserAllArticle(User user, HttpSession session, Model model){
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser.getUserId()==user.getUserId()){
            userService.deleteUserAllArticles(user.getUserId());
            return "redirect:/main.html";
        }
        model.addAttribute("msg","登录与删除博客内容的不是同一账号！");
        return "/cancel";
    }
}
