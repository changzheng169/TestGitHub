package HomeWorkTen;
import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;

/**
 * studentInformation.sql
 * drop table if exists t_student;
 * create table t_student(
 *      no int primary key auto_increment,
 *      name varchar(255),
 *      chinese int,
 *      math int,
 *      english  int
 * );
 * insert into t_student(name,chinese,math,english) values('李鹏',60,78,85);
 * insert into t_student(name,chinese,math,english) values('赵新宇',78,41,50);
 * insert into t_student(name,chinese,math,english) values('小明',85,90,85);
 */
public class StudentManagerTest {
    public static void main(String[] args) {
        HashSet<Student> arrayStudent=new HashSet<>();
        Scanner sc=new Scanner(System.in);
       while(true){
           System.out.println("****************欢迎来到学生管理系统****************");
           System.out.println("该系统有以下功能：");
           System.out.println("1.添加数据库中原有学生");
           System.out.println("2.注册,添加新学生");
           System.out.println("3.删除学生信息");
           System.out.println("4.修改学生信息");
           System.out.println("5.打印所有学生信息");
           System.out.println("6.打印不及格学生信息");
           System.out.println("7.退出学生系统");
           System.out.println("************************************************");
           System.out.print("请输入1-7，进行选择：");
           int option=sc.nextInt();
           if(option>=1&&option<=7) {
               switch (option) {
                   case 1: {
                       System.out.println("添加数据库中原有学生");
                       arrayStudent = addOldStudent(arrayStudent);
                       break;
                   }
                   case 2: {
                       System.out.println("注册,添加新学生");
                       arrayStudent = addNewStudent(arrayStudent);
                       break;
                   }
                   case 3: {
                       System.out.println("删除学生信息");
                       arrayStudent = deleteStudent(arrayStudent);
                       break;
                   }
                   case 4: {
                       System.out.println("修改学生信息");
                       arrayStudent = updateStudent(arrayStudent);
                       break;
                   }
                   case 5: {
                       System.out.println("打印所有学生信息");
                       printAllStudent(arrayStudent);
                       break;
                   }
                   case 6: {
                       System.out.println("打印不及格学生信息");
                       printLowerStudent(arrayStudent);
                       break;
                   }
                   case 7: {
                       System.exit(1);
                   }
               }
           }else{
               System.out.println("其余功能尚未开发！");
           }
       }
    }
    //自动添加原本数据库中存在的学生
    public static HashSet<Student> addOldStudent(HashSet<Student> arrayStudent){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            stmt=conn.createStatement();
            String sql="select name,chinese,math,english from t_student";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                String name=rs.getString("name");
                int chinese=rs.getInt("chinese");
                int math=rs.getInt("math");
                int english=rs.getInt("english");
                Student student=new Student(name,chinese,math,english);
                arrayStudent.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DBUtils.close(conn,stmt,rs);
        }
        return arrayStudent;
    }
    public static HashSet<Student> addNewStudent(HashSet<Student> arrayStudent){
        Scanner sc=new Scanner(System.in);
        System.out.println("依次输入想要注册，添加的学生姓名，语数外，三科成绩：");
        String name=sc.nextLine();
        int chinese=sc.nextInt();
        int math=sc.nextInt();
        int english=sc.nextInt();
        Student student=new Student(name,chinese,math,english);
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=DBUtils.getConnection();
            String sql="insert into t_student(name,chinese,math,english) values(?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,chinese);
            ps.setInt(3,math);
            ps.setInt(4,english);
            int count=ps.executeUpdate();
            System.out.println(count==1?"操作成功":"操作失败");
            arrayStudent.add(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DBUtils.close(conn,ps,null);
        }
        return arrayStudent;
    }
    //删除学生信息
    public static HashSet<Student> deleteStudent( HashSet<Student> arrayStudent){
        //保存将要删除的学生
        Student tempStudent=new Student();
        Scanner sc=new Scanner(System.in);
        System.out.print("输入要删除的学生姓名：");
        String name=sc.next();
        int flag=0;
        for(Student s:arrayStudent){
            if(name.equals(s.getName())){
                 flag=1;
                  //arrayStudent.remove(s);
                  tempStudent=s;
                  Connection conn=null;
                  PreparedStatement ps=null;
                  ResultSet rs=null;
                try {
                    conn=DBUtils.getConnection();
                    String sql="delete from t_student where name=?";
                    ps=conn.prepareStatement(sql);
                    ps.setString(1,name);
                    int count=ps.executeUpdate();
                    System.out.println(count==1?"删除学生成功":"删除学生失败");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
               finally{
                      DBUtils.close(conn,ps,null);
                }
            }
        }
        if(flag==0){
            System.out.println("查无此人！");
        }else{
            arrayStudent.remove(tempStudent);
        }
        return arrayStudent;
    }
    //修改学生信息
    public static HashSet<Student> updateStudent( HashSet<Student> arrayStudent){
        Student tempStudent=new Student();
        Student ss=new Student();
        Scanner sc=new Scanner(System.in);
        System.out.println("输入想要更新成绩的学生姓名：");
        String name=sc.nextLine();
        int flag=0;
        for(Student s:arrayStudent){
            if(name.equals(s.getName())){
                flag=1;
                System.out.println("请按语，数，外的顺序重新输入三科成绩：");
                int chinese=sc.nextInt();
                int math=sc.nextInt();
                int english=sc.nextInt();
                Student student=new Student(name,chinese,math,english);
                tempStudent=s;
                ss=student;
                //ConcurrentModificationException，对增强for循环中，集合元素进行增删引发的
                //arrayStudent.remove(s);
                //arrayStudent.add(student);
                Connection conn=null;
                PreparedStatement ps=null;
                try {
                    conn=DBUtils.getConnection();
                    String sql="update t_student set chinese= ?,math=?,english=? where name=?";
                    ps=conn.prepareStatement(sql);
                    ps.setInt(1,chinese);
                    ps.setInt(2,math);
                    ps.setInt(3,english);
                    ps.setString(4,name);
                    int count=ps.executeUpdate();
                    System.out.println(count==1?"修改成功":"修改失败");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finally{
                    DBUtils.close(conn,ps,null);
                }
            }
        }
        if(flag==0){
            System.out.println("查无此人！");
        }else{
            arrayStudent.remove(tempStudent);
            arrayStudent.add(ss);
        }
        return arrayStudent;
    }
    //打印所有学生信息
    public static void printAllStudent( HashSet<Student> arrayStudent){
            for(Student s:arrayStudent) {
                System.out.println(s);
            }
    }
    //打印不及格学生信息
    public static void printLowerStudent( HashSet<Student> arrayStudent){
        System.out.println("3科总分不及格的学生：");
           for(Student s:arrayStudent) {
               if(s.sum()<180){
                   System.out.println(s);
               }
           }
    }
}
