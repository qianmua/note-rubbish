package _18年代码_;

import java.util.concurrent.TimeUnit;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/30  16:30
 * @description :
 */
public class Demo5 {

    public static void main(String[] args) {
        D1 d1 = new D1();
        D2 d2 = new D2();

        new Thread(d1 , "鸟").start();
        new Thread(d2 , "🐖").start();

    }

    static class D1 implements Runnable{

        @Override
        public void run() {
            int n =20;
            while (n-- > 0){
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }

        }
    }
    static class D2 implements Runnable{

        @Override
        public void run() {
            int n =20;
            while (n-- > 0){
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }

        }
    }
}
