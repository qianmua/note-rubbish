package _a_juc_._AQS_;

import _a_juc_._AQS_.current.CustomLock;

import java.util.concurrent.TimeUnit;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/18  14:02
 * @description :
 */
public class Test {

    static CustomLock customLock =  new CustomLock();

    public static void main(String[] args) throws InterruptedException {
        customLock.lock();
        System.out.println("lock");
        TimeUnit.SECONDS.sleep(2);
        customLock.unLock();

        // 自旋
//        LockSupport.park();

        //
//        LockSupport.unpark();

    }
}
