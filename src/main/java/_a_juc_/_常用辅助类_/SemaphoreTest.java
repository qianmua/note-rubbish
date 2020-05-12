package _a_juc_._常用辅助类_;

import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 21:34
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        /**
         * 信号量
         *
         * 一个计数信号量。 在概念上，信号量维持一组许可证。
         * 如果有必要，每个acquire()都会阻塞，直到许可证可用，然后才能使用它。
         * 每个release()添加许可证，潜在地释放阻塞获取方。
         *
         * 固定数量同行
         *
         * */

        //限流的时候可以用到
        //并发限流，控制线程池数量
        Semaphore semaphore = new Semaphore(3);

        ThreadPoolExecutor thread = new ThreadPoolExecutor(4,
                8,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 6; i++) {
            final int finalI = i;
            thread.execute(() ->{
                try {
                    // 获得
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("get" + finalI);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("remove" + finalI);
                //释放
                semaphore.release();
            });
        }

        thread.shutdown();

    }
}
