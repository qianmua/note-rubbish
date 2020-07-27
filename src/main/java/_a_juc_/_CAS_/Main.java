package _a_juc_._CAS_;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/28
 * @time 17:27
 */
public class Main {

    /**
     *
     *
     * 什么是CAS
     * CompareAndSet比较并且交换
     *
     * 比较工作内存中和主内存中得值，如果是期望得，那么操作，如果不是，那么一直比较 -> 自旋锁
     *
     * ABA
     *
     * 乐观锁解决了 ABA 问题哦
     *
     *
     *
    * */

    /**
     * compareAndSet ->
     * return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
     *  ->
     * public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);
     *
     *  +1 自旋
     * public final int getAndAddInt(Object var1, long var2, int var4) {
     *         int var5;
     *         do {
     *             var5 = this.getIntVolatile(var1, var2);
     *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
     *
     *         return var5;
     *     }
     *
     *     compareAndSwapInt -> 是一个内存操作
     *
     * */
    public static void main(String[] args) {
        String str = "1";
        System.out.println(str instanceof Object);
        AtomicInteger integer = new AtomicInteger(100);
        integer.compareAndSet(100,101);
        integer.getAndIncrement();
        System.out.println(integer.get());
        integer.compareAndSet(100,102);
        System.out.println(integer.get());

        /*
        * Unsafe ?
        *
        * java 不能直接操作内存，但是java可以调用外部库，即native方法修饰的
        *
        * unsafe就是得
        * 底层调用内存得，使用了自旋锁
        *
        * */
    }

}
