package _a_juc_._常用辅助类_;

import _java_bridge_.C;

import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 21:08
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 减法计数器
         *
         * 允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助
         *
         * 必须等他执行完，在执行下一步，
         *  await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，
         *  之后所有等待线程被释放，并且任何后续的await 调用立即返回。
         * */
        //总数是6
        // > 0
        //倒计时
        //倒计时为0 唤醒 await
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " _->");
                countDownLatch.countDown();
            }).start();
        }
        //等待计数器归零 在向下执行
        countDownLatch.await();

        System.out.println("init");
    }
}
