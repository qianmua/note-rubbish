package _a_juc_._CAS_;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/28
 * @time 18:23
 */
public class Demo1 {

    public static void main(String[] args) {
        //原子Integer // 使用了无锁机制（CAS）
//        AtomicInteger integer = new AtomicInteger(100);
        // value 和 版本号，乐观锁喽
        //泛型是包装类，会有对象的引用问题
        // Integer 在 -128 - 127 之间 是在一个IntegerCache.cache
        // 是一个复用的对象，可以直接使用 == 判断，区间之外得会在堆中产生，只能用rq
        AtomicStampedReference<Integer> i = new AtomicStampedReference<>(100,1);
        //原子引用

        new Thread(() -> {

            //得到版本号
            int stamp = i.getStamp();
            System.out.println(stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } , "A").start();

        new Thread(() -> {
            int stamp = i.getStamp();
            System.out.println(stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } , "B").start();
    }
}
