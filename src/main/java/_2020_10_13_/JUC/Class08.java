package _2020_10_13_.JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * 集合类不安全问题
 */
public class Class08 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> vector = new Vector<>();//加锁了
        List<String> sycList = Collections.synchronizedList(new ArrayList<>());
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();//写时复制
        /*
        public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
         */


        //同理Set
        Set<String> set = new HashSet<>();
        Set<String> cpoySet = new CopyOnWriteArraySet<>();
        /**
         * Creates an empty set.
         */
//    public CopyOnWriteArraySet() {
//            al = new CopyOnWriteArrayList<E>();
//        }

        Map<String, String> map = new HashMap<>();

        //todo:Exception in thread "Thread-48" java.util.ConcurrentModificationException
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add("1");
                    vector.add("1");
                    sycList.add("1");
                    copyOnWriteList.add("1");
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("list:" + list);
        System.out.println("vector:" + vector);
        System.out.println("sycList" + sycList);
        System.out.println("copyOnWriteList" + copyOnWriteList);
    }
}
