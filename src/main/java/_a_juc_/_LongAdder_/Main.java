package _a_juc_._LongAdder_;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/28  10:29
 * @description :
 */
public class Main {

    /*
    *
    * longAdder
    * 并发包 下面的 一个 统计类
    *
    * 高性能 统计
    *
    * */

    public static void main(String[] args) {
        // 原子包下面的类
        /*
        * 底部
        * 采用无锁机制
        * cas
        * */

        // 计算式 有个 cell
        // 多线程情况下
        // cell[] 数组 总的
        // 每个线程 内 都会 有一个 cell
        //LongAdder 就是 将 每个 运算结果 都加起来
        // 然后 加上 base 结果

        //高并发 下 原子类 的使用 是非常 耗时间的
        // 所以 这个 玩意就很厉害
        // 用空间换时间


        /*
        *
        * 在 单线程下 原子 类是 更方便的
        * // 在多线程操作下
        * // 性能 好的 还是 longAdder
        * */


        /*
        * add
        *
        *
        * Cell[] as; long b, v; int m; Cell a;
        *
        * as cell 引用
        * b 得到 的base值
        * v 期望值
        * m as大小
        * a 当前线程 命中的cell 单元格
        *
        * // 进入 if
        *
        * 1、 要是 初始化过了 写入 cell 中 。没有 初始化 写入base
        * 2、 cas成功 则 false  , 失败 则 重试或者 扩容 返回 true
        *
        * // 进入 if 发生竞争
        *
        *
        * 然后 将 当前 的value 存到 cell数组 里面
        * 进行 cas 增加
        * //
        * 就是 分线程计算
        * //
        * 左后 将计算结果 统计
        * LongAdder
        *
        *
        *
        *
        *
        *
        * */


        Stack<Object> stack = new Stack<>();


        testAtocAndLongAdder(1,1000000);
        System.out.println("//===========================//");
        testAtocAndLongAdder(10,1000000);
        System.out.println("//===========================//");
        testAtocAndLongAdder(20,1000000);
        System.out.println("//===========================//");
        testAtocAndLongAdder(40,1000000);
        System.out.println("//===========================//");
        testAtocAndLongAdder(50,1000000);
        System.out.println("//===========================//");
        testAtocAndLongAdder(80,1000000);

    }

    private static void testAtocAndLongAdder(final int size , final int count){
        try {
            long v1 = System.currentTimeMillis();
            testAtomicLong(size,count);
            long v2 = System.currentTimeMillis();
            System.out.println("testAtomicLong use time -> " + (v2 -v1));


            long v1_1 = System.currentTimeMillis();
            testLongAdder(size, count);
            long v2_1 = System.currentTimeMillis();
            System.out.println(" testLongAdder use time -> " + (v2_1 -v1_1));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void testAtomicLong(final int size, final int count) throws InterruptedException{
        AtomicLong aLong = new AtomicLong();
        ArrayList<Thread> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add( new Thread( () -> {
                for (int i1 = 0; i1 < count; i1++) {
                    // 自增
                    aLong.incrementAndGet();
                }
            }));
        }

        list.forEach(Thread::start);
        for (Thread thread : list) {
            thread.join();
        }
    }

    private static void testLongAdder( final int size , final int count) throws InterruptedException{
        LongAdder adder = new LongAdder();
        ArrayList<Thread> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add( new Thread( () -> {
                for (int i1 = 0; i1 < count; i1++) {
                    // 自增
                    adder.increment();
                }
            }));
        }

        list.forEach(Thread::start);
        for (Thread thread : list) {
            thread.join();
        }
    }
}
