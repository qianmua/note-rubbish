package _动态代理_._反射_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 21:53
 */
public class B implements A {
    @Override
    public void say(String v1) {
        System.out.println("hello" + v1);
    }
}
