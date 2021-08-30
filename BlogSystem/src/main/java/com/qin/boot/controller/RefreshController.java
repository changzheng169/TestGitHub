package com.qin.boot.controller;

import com.qin.boot.entity.Article;
import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * 刷新文章
 */
@Controller
public class RefreshController {
    @Autowired
    UserService userService;
    /**
     * @return 重定向到刷新页面
     */
    @PostMapping("/success")
    public String refreshPage(){
        return "redirect:/refresh";
    }

    /**
     * @param session 提供loginUser对象
     * @param model 在请求域中添加信息
     * @return 返回页面
     */
    @GetMapping("/refresh")
    public String refreshArticle(HttpSession session, Model model){
        User loginUser = (User) session.getAttribute("loginUser");
        List<Article> articles = userService.queryAllArticles(loginUser.getUserId());
        model.addAttribute("articles",articles);
        return "main";
    }
}
