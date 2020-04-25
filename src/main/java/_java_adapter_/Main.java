package _java_adapter_;

import _java_bridge_.A;
import _java_bridge_.C;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/16
 * @time 13:14
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Adapte adapte = new Adapte();
        Adapter adapter = new Adapter();
        Adapter2 adapter2 = new Adapter2(adapte);
        computer.net(adapter);
        computer.net(adapter2);
    }
}