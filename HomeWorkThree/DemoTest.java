package HomeWorkThree;

import java.util.Scanner;

public class DemoTest {
    public static void main(String[] args) {
        int flag=0;
        System.out.println("输入1，选择手动输入时间的方式;输入2，选择程序运行时的时间");
        Scanner sc=new Scanner(System.in);
        flag=sc.nextInt();
        if(flag==1){
            //第一种测试方式
        threadSleep2 ts2=new threadSleep2();
        ts2.start();
        }
        if(flag==2) {
            //第二种测试方式
            threadSleep ts = new threadSleep();
            ts.start();
        }
   }
}

