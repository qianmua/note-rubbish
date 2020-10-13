package _2020_10_13_.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock精确唤醒（不能用notify）
 * A->B->C
 */

public class Class17 {

    static class Share{
        private static int number = 1;
        Lock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        public void print5(){
            lock.lock();
            try{
                while (number != 1){
                    c1.await();
                }
                for(int i=0; i<5; i++){
                    System.out.println("5第" + i + "次打印!");
                }
                number = 2;
                c2.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }

        public void print10(){
            lock.lock();
            try{
                while (number != 2){
                    c2.await();
                }
                for(int i=0; i<10; i++){
                    System.out.println("10第" + i + "次打印!");
                }
                number = 3;
                c3.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }

        public void print15(){
            lock.lock();
            try{
                while (number != 3){
                    c3.await();
                }
                for(int i=0; i<15; i++){
                    System.out.println("15第" + i + "次打印!");
                }
                number = 1;
                c1.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }



    }

    public static void main(String[] args) {
        Share share = new Share();
        new Thread(new Runnable() {
            @Override
            public void run() {
                share.print10();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                share.print15();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                share.print5();
            }
        }).start();
    }
}
