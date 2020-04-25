package _java_juc_.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/17
 * @time 21:14
 */
public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();

        /*
        * 先A 后 B
        * 锁的存在，谁先拿到谁先执行！
        * */
        new Thread(() -> { phone.s1();}).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> { phone.s2();}).start();

    }
}

class Phone{

    public synchronized void s1(){
        System.out.println("A");
    }

    public synchronized void s2(){
        System.out.println("B");
    }
}
