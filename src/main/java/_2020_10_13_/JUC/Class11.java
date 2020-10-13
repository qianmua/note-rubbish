package _2020_10_13_.JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author ACER
 */
public class Class11 {
    static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    static Map<Integer, Integer> map = new HashMap<>();
    static void put(int i){
        rwLock.writeLock().lock();
        try{
            map.put(i, i);
            System.out.println("key="+i+";  value=" + i);
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    static void get(int i){
        rwLock.readLock().lock();
        try{
            map.get(i);
            System.out.println("get i = " + i);
        }finally {
            rwLock.readLock().unlock();
        }

    }

    public static void main(String[] args) {
        for(int i=0; i<20; i++){
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    put(temp);
                }
            }).start();
        }

        for(int i=0; i<5; i++){
            final int  temp=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    get(temp);
                }
            }).start();
        }
    }
}
