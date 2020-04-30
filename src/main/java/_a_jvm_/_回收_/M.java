package _a_jvm_._回收_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/29
 * @time 22:45
 */
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println(" 我被垃圾回收了，调用了我。");
    }
}
