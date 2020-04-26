package _a_juc_;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 19:50
 */
public class ListTest {
    public static void main(String[] args) {
        /**
         *
         * 并发下arrayList 不安全的
         * java.util.ConcurrentModificationException 并发修改异常
         *
         * 1、 List<String> list = new Vector<>();
         * vector 默认是安全的 synchronized修饰的
         * 2、 Collections.synchronizedList
         *
         * 3、 CopyOnWriteArrayList写入时复制 COW 一种优化策略
         * 再写入的时候避免覆盖
         *
         * 读写分离
         *
         * CopyOnWriteArrayList 与 Vector 比较
         *
         *  Vector synchronized修饰的 效率低
         *  CopyOnWriteArrayList 是lock修饰的
         *  写入时复制了一份
         *
         * final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         * */

        /*List<String> list = new ArrayList<>();
        list = new Vector<>();
        list = Collections.synchronizedList(new ArrayList<>());*/
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
    }

}
