package _a_juc_;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 20:03
 */
public class SetTest {

    public static void main(String[] args) {
        /**
         * 同理得set
         * */
        Set<String> set1 = new HashSet<>();
        /*Set<String> set = new HashSet<>();
        set = Collections.synchronizedSet(new HashSet<>());*/
        Set<String> set = new CopyOnWriteArraySet<>();

        /**
         *  public HashSet() {
         *         map = new HashMap<>();
         *     }
         *
         *
         * public boolean add(E e) {
         *         return map.put(e, PRESENT)==null;
         *     }
         *
         *     PRESENT 是一个常量 Object（）
         *
         * */

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,5));
            },String.valueOf(i)).start();
        }
    }
}
