package _a_juc_._ThreadLocal_;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/29
 * @time 21:57
 */
public class Main {

    public static void main(String[] args) {
        /*
        * threadLocal
        * 线程本地存储
        * 需求 ： 线程隔离
        * 在并发情况下线程中的变量是相互独立的哦
        *
        * 多线程情况下会抢占到，别的线程数据。
        *
        * ThreadLocal 和 synchronized
        *
        *
        * ThreadLocal
        *
        * 用空间换时间
        * 提供了一个副本
        *
        * 传递数据，线程隔离 ， 避免了耦合问题
        *
        * synchronized
        *
        * 用时间换空间
        * 排队访问
        *
        *
         * */

        Demo1 demo1 = new Demo1();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2
                ,5
                ,3
                , TimeUnit.SECONDS
                ,new LinkedBlockingQueue<>(3)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 5; i++) {
            executor.execute( () ->{
                synchronized (Demo1.class){
                    demo1.setName(Thread.currentThread().getName() + " -> data");
                    System.out.println("-------------");
                    System.out.println(Thread.currentThread().getName() + " -->" + demo1.getName());
                }
            });
        }

        executor.shutdown();


    }
}


class Demo1{

    ThreadLocal<String> local = new ThreadLocal<>();

    private String name;

    public String getName() {
        return this.name;
        //将当前线程变量绑定
//        return local.get();
    }

    public void setName(String name) {
        this.name = name;
        //将当前线程变量绑定
//        local.set(name);
    }
}