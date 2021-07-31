package HomeWorkFive;
/*
问题：符合三种方法创建线程，交替输出1-120，但线程不安全，可能会输出121
 */
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
public class TestAgain {
    private static volatile int signal=1;
    private static Object obj=new Object();
    static class AThread extends Thread{
        @Override
        public void run() {
            while(signal>=1&&signal<=120){
                if(signal%3==1){
                    System.out.println("CThread:"+signal);
                    signal++;
                }
            }
        }
    }
    static class BThread implements Runnable{
        @Override
        public void run() {
            while(signal>=1&&signal<=120){
                if(signal%3==2){
                    System.out.println("CThread:"+signal);
                    signal++;
                }
            }
        }
    }
    static class CThread<Integer> implements Callable {
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
        MyThread.AThread td1=new MyThread.AThread();
        Thread td2=new Thread(new MyThread.BThread());
        Thread td3=new Thread(new FutureTask<Integer>(new MyThread.CThread<Integer>()));
        td1.start();
        td2.start();
        td3.start();
    }
}
