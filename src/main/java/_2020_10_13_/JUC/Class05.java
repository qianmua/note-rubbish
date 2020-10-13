package _2020_10_13_.JUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS：比较并交换（compare and swap）
 */
public class Class05 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        /**
         * public final boolean compareAndSet(int expect, int update) {
         *         return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
         *     }
         */
        System.out.println(atomicInteger.compareAndSet(5,6) + "   number = " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,10) + "   number = " + atomicInteger.get());


        /**
         *  public final int getAndIncrement() {
         *         return unsafe.getAndAddInt(this(当前对象）, valueOffset(内存地址）, 1);
         *     }
         */
        atomicInteger.getAndIncrement();
    }
}
