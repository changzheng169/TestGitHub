package HomeWorkTwo;
import java.util.Scanner;
public class DemoTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        myLink ml=new myLink();
        int size=0;
        //循环条件
        int flag=0;
        //链表的添加
       do{
           String name;
           int age;
           System.out.println("输入姓名：");
           name=sc.next();
           System.out.println("输入年龄：");
           age=sc.nextInt();
           Student s=new Student(name,age);
           ml.add(s);
           System.out.println("是否继续添加：继续添加就输入0");
           flag=sc.nextInt();
           size++;
       }while(flag==0);
        ml.print();
        System.out.println("==================");
      //链表元素的插入
        Student s1=new Student("李鹏",20);
        System.out.println("输入要插入的位置");
        int index=sc.nextInt();
        if(index<size){
            ml.insert(index,s1);
            size++;
        }else{
            System.out.println("越界异常，无法执行！");
        }
        ml.print();
        System.out.println("==================");
        //链表元素的删除
        System.out.println("输入要删除的位置的索引: ");
        index=sc.nextInt();
        if(index<size){
            ml.remove(index);
            size--;
        }else{
            System.out.println("越界异常，无法执行！");
        }
        ml.print();
        System.out.println("==================");
        //链表元素的改动
        System.out.println("输入要更改位置的索引：");
        index=sc.nextInt();
        if(index<size){
            String name;
            int age;
            System.out.println("输入姓名：");
            name=sc.next();
            System.out.println("输入年龄：");
            age=sc.nextInt();
            Student s=new Student(name,age);
            ml.reset(index,s);
        }else{
            System.out.println("越界异常，无法执行！");
        }
        ml.print();
        System.out.println("==================");
        //指定索引位置信息的查找
        System.out.println("输入要查找索引的位置：");
        index= sc.nextInt();
        if(index<size){
            Student temp=ml.getStudent(index);
            System.out.println(temp.getName()+","+temp.getAge());
        }else{
            System.out.println("越界异常，无法执行！");
        }
        ml.print();
        System.out.println("==================");
    }
}
