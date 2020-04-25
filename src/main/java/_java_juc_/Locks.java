package _java_juc_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/17
 * @time 19:55
 */
public class Locks {

    private Integer count = 10;

    public void prov(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (count > 0 ){
                System.out.println(Thread.currentThread().getName() + "操作时，值是" + count + " \t剩余" + count--);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
