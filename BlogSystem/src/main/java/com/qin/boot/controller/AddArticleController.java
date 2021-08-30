package com.qin.boot.controller;

import com.qin.boot.entity.Article;
import com.qin.boot.entity.User;
import com.qin.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * 添加文章
 */
import javax.servlet.http.HttpSession;
@Controller
public class AddArticleController {
    @Autowired
    ArticleService articleService;
    /**
     * @param article 文章
     * @param model 在请求域中添加信息
     * @param session 提供loginUser对象
     * @return 返回页面
     */
    @PostMapping("/addArticle")
    public String addArticle(Article article , Model model, HttpSession session){
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser.getUserId()==article.getUserId()){
            Article article1 = articleService.queryArticle(article.getArticleId());
            if(article1==null){
                articleService.addArticle(article);
                return "redirect:/main.html";
            }
            model.addAttribute("msg","文章id已被使用");
            //直接返回，${},才生效，返回main.html，再转入main，不生效
            return "/main";
        }
        model.addAttribute("msg","登录博客的id与目前id不一致");
        return "/main";
    }
}
