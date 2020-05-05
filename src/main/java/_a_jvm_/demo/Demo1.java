package _a_jvm_.demo;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 12:34
 */
public class Demo1 {

    /**
     * 一个类的 <cinit> 方法在多线程下是加锁的
     * */
    static class A{
        static int a = 1;
        static{
            a = 2;
        }
    }

    static class B extends A{
        static int b = a;
    }

    public static void main(String[] args) {
        // 为什么是2 ， 字节码
        System.out.println(new B().b);
    }
}
