package _thread_java_test_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/9
 * @time 22:53
 */
public class DemoRunnable implements Runnable{

    public static void main(String[] args) {
        DemoRunnable demoRunnable = new DemoRunnable();
        new Thread(demoRunnable).start();
        new Thread(demoRunnable).start();
        new Thread(demoRunnable).start();
    }

    @Override
    public void run() {
        System.out.println("6");
    }
}
