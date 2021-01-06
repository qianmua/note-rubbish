package _java_bridge_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/16
 * @time 12:51
 */
public class Main {

    /**
     * 桥接模式
     * @param args
     */
    public static void main(String[] args) {
        new Desk(new A()).info();
        new Book(new A()).info();
    }
}
