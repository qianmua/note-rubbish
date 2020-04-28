package _a_jmm_;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 21:58
 */
public class VolatileTest {
    /*
    *   volatile 是java 虚拟提供的轻量同步机制
    *
    *   保证可见性
    *       什么是jmm？
    *       java内存模型，不存在，概念！，约定！
    *       some：
    *       线程解锁前 必须把共享变量刷新到主存
    *       线程加锁前 必须读取主存种共享变量的最新值到工作内存
    *       加锁和解锁 是同一把锁
    *
    *   不保证原子性
    *
    *   禁止指令重排
    * */


    //加上volatile
    private static volatile int num = 0;
    public static void main(String[] args) throws InterruptedException {


        //工作内存种 num = 0
        // 死循环
        // 需要这个线程工作内存中 能见到中内存中的值得变化，即 保证可见性！
        new Thread( () -> {
            while (num == 0){

            }
            System.out.println("end");
        }).start();
        TimeUnit.SECONDS.sleep(1);
        // num = 1 写入了
        num = 1;
        System.out.println(num);



        // 原子性，不可分割诺
        //volatile不保证原子性


        //原子类Atomic
        //AtomicInteger  CAS

        AtomicInteger atomicInteger = new AtomicInteger();
        // +1   Unsafe是一个特殊得类  CAS
        atomicInteger.getAndIncrement();


        //指令重排
        //计算机执行得过程和你编写得不一样
        //code - 编译器优化重排 - 指令并行重排 - 内存系统可能重排 - 执行
        /*
        * int a = 1; // 1
        * int b = 2; // 2
        * a = a + a; // 3
        * b = a * a; // 4
        *
        * 我们编写时 1234，但是计算机执行可能时 2134 ， 1324
        *
        * //要是在线程中呢？
        *
        *
        * */

    }
}
