package _a_juc_._自旋锁_;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/28
 * @time 20:25
 */
public class Main {

    /**
     * 自旋锁，
     * 不断去循环，直到ok
     * */

    public static void main(String[] args) {
        MyLock lock = new MyLock();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2
                , 3
                ,3
                ,TimeUnit.SECONDS
                ,new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        // A 解锁 B 才能解锁
        try {
            for (int i = 0; i < 2; i++) {
                executor.execute( () -> {
                    lock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        /*new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        } ,"A").start();

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        } ,"B").start();*/
    }


}


class MyLock{
    AtomicReference<Integer> atomicReference = new AtomicReference<>(1);


    public void lock(){
        System.out.println(Thread.currentThread().getName() + " -> get lock");
        while ( !atomicReference.compareAndSet(1 , 2)){
            //自旋
        }

    }

    public void unlock(){
        atomicReference.compareAndSet(2,1);
        System.out.println(Thread.currentThread().getName() + " -> unlock");
    }
}