create table t_article(
    articleId int primary key ,
    title varchar(50),
    context text,
    userId int,
    foreign key(userId) references t_user(userId)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
