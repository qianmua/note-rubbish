package _2020_10_13_.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * countdownLatch
 */
public class Class12 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i=0; i<6; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "leave");
                    countDownLatch.countDown();
                }
            }, CountryEnum.for_eachCountryEnum(i+1).getReturnMessage()).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "      last leave");
    }
}
