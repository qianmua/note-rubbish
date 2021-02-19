package _2_demo_;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/2/19  17:21
 */
public class ThreadNotify {

    /**
     * 多线程之间通讯
     *
     * wait/notify 机制
     *
     * while 轮询
     *
     * jdk1.5 下juc 种 Condition (依赖于 Lock)
     *
     * 管道（pipeline） ，PipeInputStream
     *
     * join
     *
     * Lock (ReentrantLOck)
     *
     * Synchronized
     *
     */

    /*
    condition实现 通讯
     */
    static class ThreadA extends Thread {
        private final MyService service;
        public ThreadA(MyService service){
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitA();
        }
    }

    static class ThreadB extends Thread {
        private final MyService service;
        public ThreadB(MyService service){
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitB();
        }
    }

    static class MyService{
        private final Lock lock = new ReentrantLock();

        public Condition cA = lock.newCondition();
        public Condition cB = lock.newCondition();

        public void awaitA(){
            lock.lock();

            try {
                System.out.println("begin awaitA时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                cA.await();
                System.out.println("  end awaitA时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }


        public void awaitB(){
            lock.lock();
            try {
                System.out.println("begin awaitB时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                cB.await();
                System.out.println("  end awaitB时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signalAllA(){
            try {
                lock.lock();
                System.out.println("  signalAll_A时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                cA.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void signalAllB(){
            try {
                lock.lock();
                System.out.println("  signalAll_B时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                cB.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    @Test
    public void junConditionTest() throws InterruptedException {
        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        // Sleep

        TimeUnit.SECONDS.sleep(3);

        service.signalAllA();

        TimeUnit.SECONDS.sleep(1);
        service.signalAllB();

    }
}
