package HomeWorkFive;
/*
问题：如果给第三个线程上锁，就只会输出：
    AThread：1
    BThread：2
    如果改为两个线程交替输出，就不会出现这种情况
 */
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
public class MyThread {
    private static volatile int signal=1;
    private static Object obj=new Object();
     static class AThread extends Thread{
        @Override
        public void run() {
            synchronized (obj) {
                while (signal >= 1 && signal <= 120) {
                   if(signal%3!=1){
                       try{
                           obj.wait();
                       }catch (Exception e){
                           e.printStackTrace();
                       }
                   }else{
                       System.out.println("AThread:" + signal);
                       signal++;
                   }
                  obj.notifyAll();
                }
            }
        }
    }
    static class BThread implements Runnable{
        @Override
        public void run() {
            synchronized (obj) {
                while (signal >= 1 && signal <= 120) {
                    if(signal%3!=2){
                        try{
                            obj.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println("BThread:" + signal);
                        signal++;
                    }
                    obj.notifyAll();
                }
            }
        }
    }
     static class CThread<Integer> implements Callable{
        @Override
        public Integer call() {
            while(signal>=1&&signal<=120){
                if(signal%3==0){
                    System.out.println("CThread:"+signal);
                    signal++;
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        AThread td1=new AThread();
        Thread td2=new Thread(new BThread());
        Thread td3=new Thread(new FutureTask<Integer>(new CThread<Integer>()));
        td1.start();
        td2.start();
        td3.start();
    }
}
