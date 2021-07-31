package HomeWorkSix;

import java.util.Random;

public class MyInt {
   int data;
   MyInt(){
   }
   MyInt(int data){this.data=data;}
    //随机增加
   public int add(){
       Random r =new Random();
       int ran=r.nextInt(100);
       data+=ran;
       return ran;
   }
   //随机减少
    public int minus(){
       Random r=new Random();
       int ran=r.nextInt(100);
       data-=ran;
       return ran;
    }
}
