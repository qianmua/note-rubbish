package _a_juc_._同步队列_;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 23:05
 */
public class Main {

    public static void main(String[] args) {
        /*
        * 同步队列 SynchronousQueue<E>
        *
        * 必须取出来一个元素才能放入
        *  同步队列没有任何内部容量，甚至没有一个容量。
        * 同步队列类似于CSP和Ada中使用的会合通道。
        * 它们非常适用于切换设计，其中运行在一个线程中的对象必须与在另一个线程中运行的对象同步，
        * 以便交付一些信息，事件或任务。
        * 此类支持可选的公平策略，用于订购等待的生产者和消费者线程。
        * 默认情况下，此订单不能保证。
        * 然而，以公平设置为true的队列以FIFO顺序授予线程访问权限
        *
        * 同步队列是不存储元素得，
        *
        * */

        //同步队列，拿出后才能放入
        SynchronousQueue queue = new SynchronousQueue();

        /*>1 <1 >2 <2 >3 <3*/
        new Thread( () -> {
            try {
                System.out.println("放入1");
                queue.put("1");
                System.out.println("放入2");
                queue.put("2");
                System.out.println("放入3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("取出1");
                queue.take();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("取出2");
                queue.take();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("取出3");
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
