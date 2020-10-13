package _2020_10_13_.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS问题：ABA问题
 */
public class Class07 {
    public static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    public static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet(100, 101);
                atomicReference.compareAndSet(101, 100);
                atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
                atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicReference.compareAndSet(100,2019) + atomicReference.get().toString());
                System.out.println(atomicStampedReference.compareAndSet(100,2019,1,2));
            }
        }).start();

    }
}
