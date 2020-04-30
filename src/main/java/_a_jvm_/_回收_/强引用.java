package _a_jvm_._回收_;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/29
 * @time 22:45
 */
public class 强引用 {
    public static void main(String[] args) throws IOException {
        //强引用
        M m= new M();
        m = null;

        //显示调用gc，提醒
        System.gc();
        System.in.read();
    }
}
