package _a_juc_._AQS_;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/13  17:23
 * @description :
 */
public class Init {


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> integers = new LinkedBlockingQueue<>(10);
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        integers.put(1);
    }
}
