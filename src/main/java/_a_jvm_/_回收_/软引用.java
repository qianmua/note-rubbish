package _a_jvm_._回收_;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/29
 * @time 22:50
 */
public class 软引用 {

    public static void main(String[] args) throws InterruptedException {
        /*
        * 设置堆内存 大小 -Xmx20M
        * */
        //软引用 如果内存不够，好，那你被干掉了  适合做缓存
        SoftReference<byte[]> reference = new SoftReference<>(new byte[(1 << 20) *10]);
        // 10M

        //软引用 -> get指向的是byte
        System.out.println(reference.get());

        System.gc();

        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println(reference.get());

        //OutOfMemoryError: Java heap space
        byte[] bytes = new byte[(1 << 20) * 10];
        // 上面又分配了个10M的内存，此时装不下啦，所以软引用被回收了
        //null
        System.out.println(reference.get());

    }
}
