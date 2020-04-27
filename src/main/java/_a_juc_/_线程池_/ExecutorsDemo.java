package _a_juc_._线程池_;

import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 18:00
 */
public class ExecutorsDemo {

/**
 *  工具类， 三大方法
 *
 *  使用线程池创建线程
 * */
    public static void main(String[] args) {
        //单个线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //创建一个固定大小的线程池
//       ExecutorService executorService = Executors.newFixedThreadPool(5);
        //可伸缩的线程池
//       ExecutorService executorService = Executors.newCachedThreadPool();

       //本质

       /*
        *return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
        *
        *
        * */

       //七大参数
      /* int corePoolSize,  //核心线程池大小
        int maximumPoolSize, //最大大小
        long keepAliveTime, // 超时没有人调用就释放 ()
        TimeUnit unit, //超时单位
        BlockingQueue<Runnable> workQueue,  //阻塞队列
        ThreadFactory threadFactory, // 线程工厂
        RejectedExecutionHandler handler) //拒绝策略
        }*/

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                //阻塞队列，等待区
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),

                //四种拒绝策略

                //默认拒绝策略 , 满了，抛出异常
//                new ThreadPoolExecutor.AbortPolicy()
                //回去，谁给过来的，还给谁 // main
//                new ThreadPoolExecutor.CallerRunsPolicy()
                //直接丢掉，忽略
//                new ThreadPoolExecutor.DiscardPolicy()
                //尝试竞争
                new ThreadPoolExecutor.DiscardOldestPolicy()

        );


        try {
            for (int i = 0; i < 10; i++) {
                //使用线程池创建线程
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } finally {
            //用完即关
            executorService.shutdown();
        }
    }
}
