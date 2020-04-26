package _a_juc_._常用辅助类_;

import _java_bridge_.C;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 21:27
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        /**
         * 加法计数器
         *
         * 如果计数器 > thread 数
         * 那么就会阻塞，因为永远不会计数计够
         *
         * */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () ->{
            System.out.println("好了不计数了。。");
        });

        for (int i = 0; i < 7; i++) {
            //通过中间变量在lambda中得到i
            final int finalI = i;
            new Thread(() ->{
                System.out.println(finalI);
                try {
                    //等待计数器计数
                    cyclicBarrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}
