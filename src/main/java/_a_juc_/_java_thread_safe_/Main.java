package _a_juc_._java_thread_safe_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/11
 * @time 20:44
 */
public class Main {
    public static void main(String[] args) {
        //array lit 线程不安全
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                //加锁保证安全
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        //模拟延时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());

    }
}
