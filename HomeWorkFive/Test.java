package HomeWorkFive;
/*
问题：三个线程全部继承于Thread类
     不符合三种方法创建线程
 */
import java.util.concurrent.locks.ReentrantLock;
public class Test {
    private static volatile int signal=1;
    private static ReentrantLock lock=new ReentrantLock();
    static class myThread extends Thread{
        @Override
        public void run() {
         lock.lock();
         try {
             while (signal >= 1 && signal <= 120) {
                 if (signal % 3 == 1) {
                     System.out.println("AThread:" + signal);
                     signal++;
                 }
                 if (signal % 3 == 2) {
                     System.out.println("BThread:" + signal);
                     signal++;
                 }
                 if (signal % 3 == 0) {
                     System.out.println("CThread:" + signal);
                     signal++;
                 }
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         finally {
             lock.unlock();
         }
        }
    }
    public static void main(String[] args) {
        myThread AThread=new myThread();
        myThread BThread=new myThread();
        myThread CThread=new myThread();
        AThread.start();
        BThread.start();
        CThread.start();
    }
}
