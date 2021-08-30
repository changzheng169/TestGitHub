package com.qin.boot.entity;
/**
 * @description:博客文章类
 */

public class Article {
    private int articleId;
    private String title;
    private String context;
    private int userId;

    public Article() {
    }

    public Article(int articleId, String title, String context, int userId) {
        this.articleId = articleId;
        this.title = title;
        this.context = context;
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", userId=" + userId +
                '}';
    }
}

