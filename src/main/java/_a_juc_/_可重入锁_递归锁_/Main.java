package _a_juc_._可重入锁_递归锁_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/28
 * @time 19:50
 */
public class Main {

    /**
     * 可重入锁
     * */
    public static void main(String[] args) {
//        DemoSyn demo = new DemoSyn();
        DemoLock demo = new DemoLock();
        new Thread( () -> {
            demo.a();
        },"A").start();

        new Thread( () -> {
            demo.a();
        },"B").start();
    }
}

class DemoSyn{

    public synchronized void a(){
        System.out.println(Thread.currentThread().getName() + " A");
        // 也是一把锁，得到了a锁，也就得到了b锁，相当于一把锁，具体细节看lock
        b();
    }
    public synchronized  void b(){
        System.out.println(Thread.currentThread().getName() + " B");
    }
}

class DemoLock{
    // 锁必须配对
    Lock lock = new ReentrantLock();
    public void a(){
        lock.lock();
        try {
            System.out.println( Thread.currentThread().getName() + " A");
            b();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void b(){
        lock.lock();
        try {
            System.out.println( Thread.currentThread().getName() + " B");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
