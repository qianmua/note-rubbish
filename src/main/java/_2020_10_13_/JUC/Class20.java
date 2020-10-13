package _2020_10_13_.JUC;

import java.util.concurrent.*;

/**
 * 线程池介绍，线程池7大参数！
 * 如何设置合理的线程数？CPU密集型、IO密集型
 */
public class Class20 {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(2,
                5,1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        for(int i=0;i<8;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("aaa");
                }
            });
        }

    }
}
