package _java_juc_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/17
 * @time 19:39
 */
public class Syn {
    public static void main(String[] args) {
        Ticket tacket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                tacket.prov();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                tacket.prov();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                tacket.prov();
            }
        },"C").start();
    }
}
