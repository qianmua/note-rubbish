package _a_juc_._阻塞队列_;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 22:05
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        /**
         * BlockingQueue -> queue  和 list set 。。。。属于同级别
         * 阻塞队列
         *
         * 那里使用：
         * 多线程并发
         * 线程池
         *
         * 4种 api
         *
         * 抛出异常
         * 有返回值（不抛出）
         * 阻塞等待
         * 超时等待
         * */
        /*d1();
        d2();*/
        d3();
    }

    /** 抛异常*/
    public static void d1(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        //IllegalStateException: Queue full
//        queue.add("c");

        //查看队首
        System.out.println(queue.element());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //java.util.NoSuchElementException
//        System.out.println(queue.remove());
    }

    /** 不抛异常 , 返回值*/
    public static void d2(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.offer("a");
        queue.offer("a");
        queue.offer("a");
        //false
        queue.offer("a");

        //检测队首
        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //null
        System.out.println(queue.poll());
    }

    /** 死阻塞*/
    public static void d3() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

        queue.put("a");
        queue.put("b");
        queue.put("c");
        //阻塞线程
//        queue.put("d");

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        //阻塞
//        System.out.println(queue.take());

    }

    /** 超时阻塞*/
    public static void d4(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.offer("a");
        queue.offer("a");
        queue.offer("a");
        //超时
        queue.offer("a");

    }


}
