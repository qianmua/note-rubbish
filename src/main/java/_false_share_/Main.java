package _false_share_;

import _false_share_.test.SnowFlakeIDGenerator;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/10  10:58
 */
public class Main {

    /**
     * 伪共享问题
     *  一亿次测试
     * :2791 :604
     * 一百万次测试
     * :8323 :
     *
     *
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        SnowFlakeIDGenerator volatileLong = new SnowFlakeIDGenerator();
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                volatileLong.generateId();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                volatileLong.generateId();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(System.currentTimeMillis() - start);
    }
}
class VolatileLong {
    public volatile long value1;
    public long p1, p2, p3, p4, p5, p6;     // 注释此行，时间会比较长
    public volatile long value2;
}
