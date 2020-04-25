package _thread_java_test_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/9
 * @time 23:01
 */
public class Demo implements Runnable{
    private int a = 10;
    public static void main(String[] args) {
        //并发问题！
        Demo demo = new Demo();
        new Thread(demo,"A").start();
        new Thread(demo,"B").start();
        new Thread(demo,"C").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < a; i++) {
            if (a < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 是" + a--);

        }
    }
}
