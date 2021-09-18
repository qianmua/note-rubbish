package _java_time_loop_;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author mu.qian
 * @date 2021/9/14  15:50
 */
public class TimingWheel {
    //
    public static void main(String[] args) {
        TimerWheelTask timerWheelTask = new TimerWheelTask();
        Timer timer = new HashedWheelTimer();
        timer.newTimeout(timerWheelTask , 5 , TimeUnit.SECONDS);
    }

    public static class TimerWheelTask implements TimerTask {
        boolean flag = false;

        @Override
        public void run(Timeout timeout) throws Exception {
            System.out.println("delete");
            this.flag = false;
        }
    }



    public static void delayQueueDemo() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("00001");
        strings.add("00002");
        strings.add("00003");
        strings.add("00004");
        strings.add("00005");

        DelayQueue<Order> orders = new DelayQueue<>();

        long l = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            orders.put(new Order(strings.get(i) , TimeUnit.NANOSECONDS.convert(3 , TimeUnit.SECONDS)));
            try {
                orders.take().print();
                System.out.println("After " +
                        (System.currentTimeMillis()-l) + " MilliSeconds");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // jdk delay queue
    static class Order implements Delayed {
        private String id;
        private long timeout;

        public Order(String id, long timeout) {
            this.id = id;
            this.timeout = timeout + System.nanoTime();
        }

        /**
         * 剩余时长
         * @param unit
         * @return
         */
        @Override
        public long getDelay(@NotNull TimeUnit unit) {
            return unit.convert(timeout - System.nanoTime() , TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(@NotNull Delayed o) {
            if (o == this)
                return 0;
            Order t = (Order) o;

            long d = (getDelay(TimeUnit.NANOSECONDS) - t
                    .getDelay(TimeUnit.NANOSECONDS));

            return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
        }

        void print() {
            System.out.println(id+"编号的订单要删除啦。。。。");
        }

    }
}
