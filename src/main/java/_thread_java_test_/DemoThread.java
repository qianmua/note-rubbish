package _thread_java_test_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/9
 * @time 22:43
 */
public class DemoThread {

    public static void main(String[] args) {
        //代理
        new Thread(() ->{
            for (int i = 0; i < 1000; i++) {
                System.out.println("$$$$$$$$$$$$$$$$");
            }
        }).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("++++++++++++++++++++++++++");
        }
    }
}
