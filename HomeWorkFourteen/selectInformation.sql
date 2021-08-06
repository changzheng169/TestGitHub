select courseNo,max(studentScore) as maxScore,min(studentScore) as minScore from t_score group by courseNo;
select s.studentName,t.* from(select studentNo,sum(studentScore) as sumScore from t_score group by studentNo) as t
	 join t_student s 
	on t.studentNo=s.studentNo 
	order by t.sumScore desc;
select studentNo,avg(studentScore) as avgScore from t_score group by studentNo;