package HomeWorkSix;

import java.util.Scanner;

public class DemoTest {
    public static void main(String[] args) {
       int data;
       Scanner sc=new Scanner(System.in);
        System.out.println("输入要测试的数据：");
        data=sc.nextInt();
        MyInt Int=new MyInt(data);
        try{
           int ran=Int.add();
            System.out.println("随机增加数："+ran);
           checkInt(Int.data);
        }catch(IntException e){
            e.printStackTrace();
        }
    }
    public static void checkInt(int data) throws IntException {
        Integer s=data;
        if(s>127||s<-128){
            throw new IntException("所给数据超出范围！");
        }else{
            System.out.println("所给数据正常");
        }
    }
}
