drop table if exists t_teacher;
drop table if exists t_score;
drop table if exists t_course;
drop table if exists t_student;
create table t_student(
	studentNo   int  primary key,
	studentName  varchar(255),
	birthday  date,
	gender  char(1)
);
create table t_course(
	courseNo int primary key,
	courseName varchar(255),
	teacherNo int unique
);
create table t_score(
	studentNo  int,
	courseNo  int,
	studentScore  int,
	foreign key(studentNo) references t_student(studentNo),
	foreign key(courseNo) references t_course(courseNo)	
);
create table t_teacher(
	teacherNo int,
	teacherName varchar(255),
	foreign key(teacherNo) references t_course(teacherNo)	
);
insert into t_student(studentNo,studentName,birthday,gender) values(101,'李鹏','2001-09-10','男');
insert into t_student(studentNo,studentName,birthday,gender) values(102,'潇潇','2002-02-11','女');
insert into t_student(studentNo,studentName,birthday,gender) values(103,'小明','2001-11-12','男');
insert into t_course(courseNo,courseName,teacherNo) values(201,'数据结构',301);
insert into t_course(courseNo,courseName,teacherNo) values(202,'java程序设计',302);
insert into t_course(courseNo,courseName,teacherNo) values(203,'投资与理财',303);
insert into t_score(studentNo,courseNo,studentScore) values(101,201,91);
insert into t_score(studentNo,courseNo,studentScore) values(101,202,92);
insert into t_score(studentNo,courseNo,studentScore) values(101,203,84);
insert into t_score(studentNo,courseNo,studentScore) values(102,201,88);
insert into t_score(studentNo,courseNo,studentScore) values(102,202,90);
insert into t_score(studentNo,courseNo,studentScore) values(102,203,94);
insert into t_score(studentNo,courseNo,studentScore) values(103,201,97);
insert into t_score(studentNo,courseNo,studentScore) values(103,202,96);
insert into t_score(studentNo,courseNo,studentScore) values(103,203,95);
insert into t_teacher(teacherNo,teacherName) values(301,'吴辉');
insert into t_teacher(teacherNo,teacherName) values(301,'李刚');
insert into t_teacher(teacherNo,teacherName) values(301,'赵悦');
select * from t_student;
select * from t_score;
select * from t_course;
select * from t_teacher;
commit;








