package _a_jvm_._回收_;

import java.lang.ref.WeakReference;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/29
 * @time 23:11
 */
public class 弱引用 {
    public static void main(String[] args) {

        /*
        * 弱引用遇到gc就被回收啦
        * */
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());

        System.gc();

        System.out.println(m.get());
    }
}
