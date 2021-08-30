package com.qin.boot.controller;

import com.qin.boot.entity.Article;
import com.qin.boot.entity.User;
import com.qin.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
/**
 * 更改文章
 */
@Controller
public class UpdateArticleController {
    @Autowired
    ArticleService articleService;

    /**
     * @return 跳转到更改页面
     */
    @GetMapping("/updateArticle")
    public String updatePage(){
        return "/updateArticle";
    }

    /**
     * @param articleId
     * @param userId
     * @param session
     * @param model
     * @return 通过以上信息查询除要更该的文章
     */
    @PostMapping("/updateArticle")
    public String updateArticle(@RequestParam("articleId") int articleId,@RequestParam("userId") int userId,
                                HttpSession session, Model model){
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser.getUserId()==userId){
            Article article = articleService.queryArticle(articleId);
            if(article!=null){
                model.addAttribute("userID",article.getUserId());
                model.addAttribute("title",article.getTitle());
                model.addAttribute("articleID",article.getArticleId());
                model.addAttribute("article",article.getContext());
                return "/updateArticle";
            }
            model.addAttribute("msg","没有此文章");
            return  "/updateArticle";
        }
        model.addAttribute("msg","登录博客的id与目前id不一致");
        return "/updateArticle";
    }
    /**
     * 更改操作
     * @param article
     * @return
     */
    @PostMapping("/updateSubmit")
    public String updateSubmit(Article article){
        articleService.updateArticle(article);
        return "redirect:/main.html";
    }
}
