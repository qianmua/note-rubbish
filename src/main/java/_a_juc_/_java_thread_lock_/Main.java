package _a_juc_._java_thread_lock_;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/11
 * @time 21:52
 */
public class Main {
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
    }
}
class LockTest extends Thread{
    private int a = 10;
    private final ReentrantLock r = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            r.lock();
            try {
                if (a > 0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("拿到了" + a--);
                }else {
                    break;
                }
            }finally {
                r.unlock();
            }
        }
    }
}
