package _java_thread_yield_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 15:12
 */
public class Main {
    public static void main(String[] args) {
        YieldTest yieldTest = new YieldTest();
        new Thread(yieldTest,"A").start();
        new Thread(yieldTest,"B").start();
    }
}

/**
 * 线程礼让， 礼让不一定成功哦
 *
 */
class YieldTest implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 第一次");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " 第二次");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
