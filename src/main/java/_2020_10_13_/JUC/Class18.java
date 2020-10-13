package _2020_10_13_.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模式，阻塞队列方式
 */
public class Class18 {


    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource(new ArrayBlockingQueue<String>(10));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    resource.prod();
                    System.out.println("生产！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    resource.comsum();
                    System.out.println("消费！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(10);
        resource.stop();

    }
}

     class Resource{
        private volatile boolean Flag = true;//注意volatile
        AtomicInteger atomicInteger = new AtomicInteger();
        BlockingQueue<String> blockingQueue = null;

         public Resource(BlockingQueue<String> blockingQueue) {
             this.blockingQueue = blockingQueue;
         }

         public void prod() throws InterruptedException {
            String data = null;
            boolean retVal;
            while(Flag){
                data = atomicInteger.incrementAndGet() + " ";
                retVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
                if(retVal){
                    System.out.println("插入队列"+ data + "成功！");
                }else {
                    System.out.println("插入队列"+ data + "失败！");
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("prod结束！");
        }

        public void comsum() throws InterruptedException {
            String res = null;
            while(Flag){
                res = blockingQueue.poll(2, TimeUnit.SECONDS);
                if(res == null || res.equals("")){
                    Flag = false;
                    System.out.println("超时退出！");
                    return;
                }
                System.out.println("取到" + res);
            }
        }

        public void stop(){
             Flag = false;
        }
    }

