package _2020_10_13_.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 * @author ACER
 */
public class Class15 {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue  = new ArrayBlockingQueue<>(5);
        for(int i=0; i<6; i++){
            System.out.println(blockingQueue.offer("a"));
        }

        for(int i=0; i<6; i++){
            System.out.println(blockingQueue.poll());
        }


        //当队列满，阻塞
        for(int i=0; i<5; i++){
            try {
                blockingQueue.put("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i=0; i<6; i++){
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
