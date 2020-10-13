package _2020_10_13_.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平和非公平锁, synchronized是非公平锁
 * @author ACER
 */
public class Class09 {
    Lock unfairLock = new ReentrantLock();
    Lock fairLock = new ReentrantLock(true);

    public static synchronized void sendMsg(){
        System.out.println(Thread.currentThread().getId() + "message");
        sendEmail();
    }

    public static synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getId() + "sendEmail");
    }

    public void getA(){
        unfairLock.lock();

        try{
            System.out.println(Thread.currentThread().getId() + "getA");
            getB();
        }finally {
            unfairLock.unlock();
        }

    }

    public void getB(){
        unfairLock.lock();
        //unfairLock.unlock();  //不会报错，但是程序会卡死
        try{
            System.out.println(Thread.currentThread().getId() + "getB");
        }finally {
            unfairLock.unlock();
        }

    }


    //可重入锁（最大的作用是避免死锁）
    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sendMsg();
                }
            }).start();
        }

        for(int i=0; i<5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sendEmail();
                }
            }).start();
        }

        Class09 class09 = new Class09();
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    class09.getA();
                }
            }).start();
        }
    }

}
