package HomeWorkThree;

import java.util.Scanner;

//第一种：手动输入时间
public class threadSleep2 extends Thread {
    @Override
    public void run() {
        int second;//秒
        int  minute;//分
         int hour;//时
        int day;//日
        int month;//月
        int year;//年
        System.out.println("依次输入年月日，时分秒");
        Scanner sc=new Scanner(System.in);
        year=sc.nextInt();
        month=sc.nextInt();
        day=sc.nextInt();
        hour=sc.nextInt();
        minute=sc.nextInt();
       second=sc.nextInt();
        Clock c=new Clock(year,month,day,hour,minute,second);
        for(int i=0;i<10;i++){
            System.out.println(c.getYear()+"年"+c.getMonth()+"月"+c.getDay()+"日"+"    "+
                    c.getHour()+"时"+c.getMinute()+"分"+ c.getSecond()+"秒");
            try{
                Thread.sleep(1000);
                 second=c.getSecond();//秒
                 minute=c.getMinute();//分
                 hour=c.getHour();//时
                 day=c.getDay();//日
                 month=c.getMonth();//月
                 year=c.getYear();//年
                second+=1;
                if(second>=60){
                    second=0;
                    minute+=1;
                }
                c.setSecond(second);
                if(minute>=60){
                    minute=0;
                    hour+=1;
                }
                c.setMinute(minute);
                if(hour>=12){
                    hour=0;
                    day+=1;
                }
                c.setHour(hour);
                if(day>=31){
                    day=1;
                    month+=1;
                }
                c.setDay(day);
                if(month>=12){
                    month=1;
                    year+=1;
                }
                c.setMonth(month);
                c.setYear(year);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
