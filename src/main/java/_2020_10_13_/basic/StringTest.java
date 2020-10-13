package _2020_10_13_.basic;

import java.util.concurrent.Semaphore;

public class StringTest {
    final Semaphore get = new Semaphore(0);
    public static void main(String[] args) {
        System.out.println("abc");
        String cde = "cde";
        System.out.println("abc" + cde);
        String c = "abc".substring(2,3);
        System.out.println("c" + c);
        String d = cde.substring(1, 2);
        System.out.println("d" + d);
    }
}
