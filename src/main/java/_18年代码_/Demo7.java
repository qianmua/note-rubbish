package _18年代码_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/2  14:03
 * @description :
 */
public class Demo7 {

    public static void main(String[] args) {
        String s1 = "hello";

        System.out.println(s1.hashCode());

        s1 = s1 + " world";

        System.out.println(s1.hashCode());

        String s2 = "hello";
        System.out.println(s2.hashCode());

        String s3 = new String("hello").intern();
        System.out.println(s3.hashCode());

        String s4 = new String("hello");
        System.out.println(s4.hashCode());

        System.out.println(s4.equals(s2));
    }

    abstract static class Demo7_1 extends Demo8_3 implements Demo7_2{

        public static void main(String[] args) {

        }

        abstract void m2();

//        public abstract void m1();
    }

    interface Demo7_2{
        void m1();

        static void m3() {

        }
    }

    static class Demo8_3{}
}

