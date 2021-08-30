package com.qin.boot.service;

import com.qin.boot.entity.Article;


public interface ArticleService {
    //通过文章id，查询文章内容
    Article queryArticle( int articleId);
    //添加文章
    int addArticle(Article article);
    //通过文章id删除文章
    int deleteArticle( int articleId);
    //通过文章id，更改文章
    int updateArticle(Article article);
    //通过文章名，和作者id查询文章内容
    Article queryArticleByInfo(String title,int userId);

}
