package _2020_10_13_.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模式
 * lock相比于synchronized的优点：
 * 1.synchronized是java的关键字，lock是API层面，synchronized底层是通过monitor对象来控制
 * 2.synchronized可以不释放锁
 * 3.synchronized不可中断，ReentrantLock可以
 * 4.synchronized非公平锁，ReentrantLock都可以
 * 5.synchronized无法精确唤醒特定线程
 */
public class Class16 {
    static class Age{

        static int age=0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment(){
            lock.lock();
            try{

                while(age!=0){//不能用if判断
                    condition.await();
                }
                age ++;
                System.out.println("++" + age);
                condition.signalAll();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }

        }

        public void decrement(){
            lock.lock();
            try{

                while(age!=1){//不能用if判断
                    condition.await();
                }
                age --;
                System.out.println("--" + age);
                condition.signalAll();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }

        }

        public static void main(String[] args) {
            Age age = new Age();
            for(int i=0; i<5; i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        age.increment();
                    }
                }).start();
            }

            for(int i=0; i<5; i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        age.decrement();
                    }
                }).start();
            }
        }
    }
}
