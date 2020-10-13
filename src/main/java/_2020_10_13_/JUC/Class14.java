package _2020_10_13_.JUC;

import java.util.concurrent.Semaphore;

/**
 * Semaphore:多个共享资源，多对多
 * @author ACER
 */
public class Class14 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for(int i=0; i<8; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "   得到资源！");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "   释放资源!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            }).start();
        }
    }
}
