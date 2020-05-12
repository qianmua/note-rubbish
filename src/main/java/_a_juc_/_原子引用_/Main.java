package _a_juc_._原子引用_;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/12
 * @time 13:40
 */
public class Main {

    /**
     * 有原子Integer 等 其他的我们自定义得类可以用原引用这个东西
     * */
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();

        //原子引用
        AtomicReference<User> atomicReference = new AtomicReference<>();
        // 原子包装
        atomicReference.set(user);
    }
}
