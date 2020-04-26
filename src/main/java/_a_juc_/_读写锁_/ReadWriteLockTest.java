package _a_juc_._读写锁_;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 21:43
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        /**
         * ReadWriteLock维护一对关联的locks ，一个用于只读操作，一个用于写入。
         * read lock可以由多个阅读器线程同时进行
         *
         * */

        MyCache myCache = new MyCache();

        for (int i = 1; i < 5; i++) {
            final int finalI = i;
            new Thread( () -> {
                myCache.put(finalI + "", finalI + "");
            },String.valueOf(i)).start();

        }

        for (int i = 1; i < 5; i++) {
            final int finalI = i;
            new Thread( () -> {
                myCache.get(finalI + "");
            },String.valueOf(i)).start();

        }
    }
}

/**
 * 测试
 * */
class MyCache{
//    volatile 操作原子性
    private volatile Map<String,Object> map = new HashMap<>();

    //读写锁  控制原子性，细粒度
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,String value){
        //写锁  独占锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +" write.");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + " write end..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }


    public void get(String key){
        //读锁  共享锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "read.");
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "read end..");
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}