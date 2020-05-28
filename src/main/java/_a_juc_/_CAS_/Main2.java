package _a_juc_._CAS_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/28  11:22
 * @description :
 */
public class Main2 {

    /*
    * demo1模拟 访问
    *
    * */
    private static int count = 0;

    private static void req() throws InterruptedException{
        // 模拟 网络延时
        TimeUnit.SECONDS.sleep(2);

        /*
        * ++ 问题
        *
        *
        * 加锁 实现 串行化访问资源
        *
        * 重量级锁 占用 资源 synchronized
        *
        * 解决 资源 占用
        *
        * cas 实现
        *
        * cas 还快了。。
        *
        * 并没有 轻量级锁的原因 hh
        *
        *  开销 小
        * 哈哈
        * 代替 synchronized ？？？
        *
        * */
        int v1;
        while ( !compareAndSwap(v1 =getCount() , v1 + 1));
    }

    private static synchronized boolean compareAndSwap(int v1 , int v2){
        if ( getCount() == v1){
            count = v2;
            return true;
        }
        return false;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        long millis = System.currentTimeMillis();
        int size = 100;
        CountDownLatch downLatch = new CountDownLatch(100);

        for (int i = 0; i < size; i++) {
            new Thread( () -> {
                try {
                    req();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                     downLatch.countDown();
                }
            }).start();
        }
        long milli2 = System.currentTimeMillis();
        // 等待结束
        downLatch.await();
        System.out.println("user time -> " + (milli2 - millis));
        System.out.println(" size -> " + count); // err



    }
}
