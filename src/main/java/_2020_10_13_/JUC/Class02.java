package _2020_10_13_.JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 第一课
 * 1.并发和并行的区别：
 *      并发：多个线程访问同一个资源
 *      并行：一个程序同时执行多件事
 * 2.请谈谈你对volatile的理解：
 *      a.volatile是java虚拟机提供的一种轻量级的同步机制（轻量级怎么理解？），具有3大特性：1.保证可见性，2.不保证原子性，3.禁止指令重排
 *      b.JMM：java内存模型(参考思维导图）。具有：1.可见性，2.原子性，3.有序性。volatile不保证原子性是其轻量的原因。
 */

public class Class02 {
    //验证可见性
    public static volatile int A = 0;
    public static int B = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    A = 60;
                    TimeUnit.SECONDS.sleep(3);
                    B = 60;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while(A == 0){
            //空转
        }
        System.out.println("A = " + A);
        while (B == 0){
            //空转
        }
        System.out.println("B = " + B);
    }
}
