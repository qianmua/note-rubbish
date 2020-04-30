package _a_juc_._ThreadLocal_;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/30
 * @time 20:07
 */
public class Demo2 {


    /*
    *
    * thread 维护了一个 threadLocal
    * threadLocal 里面有个Map (ThreadLocalMap 是它里面的一个静态内部类哦)
    * threadLocal.set 把 东西，存到set和value里面了，
    * 所以只在当前线程可以得到哦
    * */


    /**
     * Thread t = Thread.currentThread();
     *         ThreadLocalMap map = getMap(t);
     *         if (map != null)
     *             map.set(this, value);
     *         else
     *             createMap(t, value);
     *
     * */
    static ThreadLocal<P> local = new ThreadLocal<>();

    public static void main(String[] args) {
        P p = new P();
        new Thread( () ->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // NPE
            System.out.println(local.get().name);
        }).start();

        new Thread( () ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            local.set(p);
        }).start();


        //用完了，记得remove掉，不然会造成内存泄露啦
        /*
        * 原因分析：
        * 存的时候会new一个Entity，这个Entity继承了一个弱引用WeekReference
        * 即你这个set是指向了的一个弱引用
        * 但当你这个虚引用被gc了 ，key被回收了，但是value？
        * value 没有被回收，永远不可能被回收啦~
        * 所以会造成内存泄露的
        * 当我们不用这个的时候记得remove掉哦
        * */
        local.remove();
    }
}

class P{
    String name = "h'h'h";
}
