package _a_juc_._demo_;

import java.util.concurrent.TimeUnit;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/10  22:07
 * @description :
 */
public class Init {


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        new Thread(() -> {
            while (demo1.v1 >= 0){
                demo1.run();
            }
        }, "A").start();
        new Thread(() -> {
            while (demo1.v1 >= 0){
                demo1.run();
            }
        }, "B").start();
    }


}
class Demo1{
    int v1 = 100;

    public synchronized void run(){
        /*try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println( "线程name ->" + Thread.currentThread().getName() + "票数 ->\t\t" + v1--);
    }
}


