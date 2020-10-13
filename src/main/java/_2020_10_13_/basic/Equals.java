package _2020_10_13_.basic;

import java.util.HashMap;

/**
 * == 是一个运算符。 equals则是string对象的方法。
 */
public class Equals {
    //java中 值类型的变量（即基本的诸如int、float等） 是存储在内存中的栈中。
    // 而引用类型（对象）在栈中仅仅是存储引用类型变量的地址，而其本身则存储在堆中。
    // 所以字符串的内容相同，引用地址不一定相同，有可能创建了多个对象。

    //String类是不可变类 String s = "Hello"; //--1 String s1=new String("World");//---2
    // 方式1是申请的变量存放在常量池中的，这是java的性能优化所做的。也就是说每创建一个字符串，虚拟机就要创建一个新的对象，
    // 因为String是不可变类，因此，虚拟机做出优化，将字符串放入常量池，实现对不同字符串的引用。
    // 第二种方法是使用new创建的对象，那么会在堆区申请内存，对于大量的这样的操作，这个开销是很大的，所以不建议使用第二种方式。

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        System.out.println(s1 == s2);

        String s3 = new String("456");
        String s4 = new String("456");
        System.out.println(s3 == s4);

    }
}
