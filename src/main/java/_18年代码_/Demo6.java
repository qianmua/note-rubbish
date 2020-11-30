package _18年代码_;

import java.util.concurrent.TimeUnit;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/30  16:45
 * @description :
 */
public class Demo6 {

    public static void main(String[] args) {
        DDD6 ddd6 = new DDD6();


        new Thread( ddd6 , "1").start();
        new Thread( ddd6 , "2").start();
        new Thread( ddd6 , "3").start();
        new Thread( ddd6 , "4").start();
    }
}

class DDD6 implements Runnable{

    int n = 20;

    @Override
    public synchronized void run() {
        while (n > 0){
            try {
                System.out.println(Thread.currentThread().getName() + " 卖出 -》 " + n--);
                this.notifyAll();

                TimeUnit.MILLISECONDS.sleep(200);
                if (n > 0)
                    this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
            }
        }
    }
}
