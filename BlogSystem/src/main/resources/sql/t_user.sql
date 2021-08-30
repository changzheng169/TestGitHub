create table t_user(
    userId   int primary key ,
    username     varchar(50) unique,
    password  varchar(50),
    introduction text
) ENGINE=INNODB DEFAULT CHARSET=utf8;
