package com.qin.boot.controller;

import com.qin.boot.entity.User;
import com.qin.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 删除文章
 */
@Controller
public class deleteArticleController {
    @Autowired
    ArticleService articleService;
    /**
     * @return 跳转删除页面
     */
    @GetMapping("/delete")
    public String deletePage(){
        return "/delete";
    }

    /**
     * @param articleId 文章ID
     * @param userId 用户ID
     * @param model  在请求域中添加信息
     * @param session  提供loginUser对象
     * @return 返回页面
     */
    @PostMapping("/delete")
    public String  deleteArticle(@RequestParam("articleId") int articleId,
                                 @RequestParam("userId") int userId,
                                 Model model, HttpSession session
                                 ){
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser.getUserId()==userId){
            if(articleService.queryArticle(articleId)!=null){
                articleService.deleteArticle(articleId);
                return "redirect:/main.html";
            }
            model.addAttribute("msg","没有此文章id！");
            return "/delete";
        }
        model.addAttribute("msg","登录与删除博客内容的不是同一账号！");
        return "/delete";
    }
}
