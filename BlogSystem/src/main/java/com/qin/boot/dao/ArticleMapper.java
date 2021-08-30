package com.qin.boot.dao;

import com.qin.boot.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    //添加文章
    int addArticle(Article article);
    //通过文章id更改博客内容
    int updateArticle(Article article);
    //通过文章id删除文章
    int deleteArticle(@Param("articleId") int articleId);
    //通过文章id，查询文章内容
    Article queryArticle(@Param("articleId") int articleId);
   //通过文章名和作者id查询文章内容
    Article queryArticleByInfo(@Param("title")String title,@Param("userId") int userId);

}
