package _18年代码_;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/25  15:34
 * @description :
 */
public class Demo2 {

    private static int testTryReturn(){
        int a = 1;
        try {
            return ++a;
        }catch (Exception e){

        }finally {
            System.out.println(a);
            a = 3;
        }
        return 0;
    }


    public static void main(String[] args) {
        int i = testTryReturn();

        System.out.println(i);
    }


    @Test
    public void m1(){
        A<Integer> a = new A<>();
        a.var = 1;

        A<String> a1 = new A<>();

        a1.var = 2;

        System.out.println(a.var);


    }

    static class A<T>{
        static Integer var = 0;

        private void nothing(T t){

        }
    }
}
