package _18年代码_;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/3  17:43
 * @description :
 */
public class Demo9 {

    public static void main(String[] args) {
        new Demo9_1().m3();
    }

    static class Demo9_1{

        void m1(){
            System.out.println(Thread.holdsLock(this));
        }
        synchronized void m2(){
            System.out.println(Thread.holdsLock(this));
        }

        void m3(){
            Thread.dumpStack();

//            System.out.println(Thread.activeCount());

            System.out.println(Arrays.toString(Thread.State.values()));
        }
    }
}
