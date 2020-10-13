package _2020_10_13_.JUC;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 */
public class Class21 {
    public static void main(String[] args) {
        String A = "lockA";
        String B = "lockB";

        new Thread(new MyThread(A,B)).start();
        new Thread(new MyThread(B,A)).start();
    }
}


class MyThread implements Runnable{
    public String a;
    public String b;

    public MyThread(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a){
            System.out.println("持有"+a+"，尝试持有"+b+"！");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println("持有"+b+"！");
            }
        }
    }
}