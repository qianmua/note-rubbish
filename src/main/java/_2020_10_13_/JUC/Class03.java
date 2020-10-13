package _2020_10_13_.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证volatile不保证原子性（完整性，即某个线程在操作volatile数据时，别的线程可以“加塞”
 */
public class Class03 {
    public static volatile int A = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger();//解决方法

    public static void main(String[] args) {
        for(int i=0; i<30; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<2000; j++){
                        A++;
                        atomicInteger.getAndIncrement();//增加1
                        //atomicInteger.getAndAdd(5);增加5
                    }
                }
            }).start();
        }
        //等待一会
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("A answer is: " + A);
        System.out.println("atomicInteger answer is: " + atomicInteger);
    }
}
