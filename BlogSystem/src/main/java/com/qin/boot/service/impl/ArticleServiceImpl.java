package com.qin.boot.service.impl;

import com.qin.boot.dao.ArticleMapper;
import com.qin.boot.entity.Article;
import com.qin.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public Article queryArticle(int articleId) {
        return articleMapper.queryArticle(articleId);
    }
    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int deleteArticle(int articleId) {
        return articleMapper.deleteArticle(articleId);
    }
    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public Article queryArticleByInfo(String title, int userId) {
        return articleMapper.queryArticleByInfo(title,userId);
    }
}
