 studentInformation.sql                                                     
 drop table if exists t_student;                                            
 create table t_student(                                                    
      no int primary key auto_increment,                                    
      name varchar(255),                                                    
      chinese int,                                                          
      math int,                                                             
      english  int                                                               
 );                                                                         
 insert into t_student(name,chinese,math,english) values('李鹏',60,78,85);    
 insert into t_student(name,chinese,math,english) values('赵新宇',78,41,50);   
 insert into t_student(name,chinese,math,english) values('小明',85,90,85);    