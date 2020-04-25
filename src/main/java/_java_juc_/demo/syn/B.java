package _java_juc_.demo.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/17
 * @time 20:37
 */
public class B {

    public static void main(String[] args) {
        Option option = new Option();
        new Thread( () ->{
            for (int i = 0; i < 10; i++) {
                    option.add();
            }
        },"A").start();
        new Thread( () ->{

            for (int i = 0; i < 10; i++) {
                    option.del();
            }
        },"B").start();
        new Thread( () ->{

            for (int i = 0; i < 10; i++) {
                    option.add();
            }
        },"C").start();
        new Thread( () ->{
            for (int i = 0; i < 10; i++) {
                    option.del();
            }
        },"D").start();
    }
}

class Option{
    private int num = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            while (num != 0 ){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "消费" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void del() {
        lock.lock();
        try {
            while (num != 0 ){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "消费" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}