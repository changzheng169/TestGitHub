package HomeWorkThree;

import java.text.SimpleDateFormat;
import java.util.Date;
//第二种：程序运行时间
public class threadSleep extends Thread {
    @Override
    public void run() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        for(int i=0;i<10;i++){
            System.out.println(sdf.format(new Date()));
            //线程调控，实现每隔1秒，输出年月日，时分秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
