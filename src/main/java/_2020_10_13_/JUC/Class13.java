package _2020_10_13_.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 * @author ACER
 */
public class Class13 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("big boss！！！！！！！！");
            }
        });

        for(int i=0; i<7; i++){
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("the: " + temp);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
