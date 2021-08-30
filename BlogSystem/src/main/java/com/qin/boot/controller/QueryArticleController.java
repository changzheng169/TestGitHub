package com.qin.boot.controller;

import com.qin.boot.entity.Article;
import com.qin.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 查询文章
 */
@Controller
public class QueryArticleController {
    @Autowired
    ArticleService articleService;
    /**
     * @return 跳转查询页面
     */
    @GetMapping("/queryArticle")
    public String queryPage(){
        return "/queryArticle";
    }

    /**
     * @param title 文章标题
     * @param userId 用户ID
     * @param model  在请求域中添加信息
     * @return 返回页面
     */
    @PostMapping("/queryArticle")
    public String queryArticle(@RequestParam("title") String title, @RequestParam("userId") int userId, Model model) {
           Article article = articleService.queryArticleByInfo(title, userId);
           if (article != null) {
               model.addAttribute("article", article.getContext());
               return "/queryArticle";
           }
           model.addAttribute("article", "没有该文章");
           return "/queryArticle";
    }
}
