package _a_alg_.leetCode;

import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  14:11
 */
public class _268 {

    /**
     *
     给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     */
    @Test
    public void __268(){
        System.out.println(mn(new int[]{9, 8, 4, 2, 3, 5, 7, 0, 1}));
    }

    private int mn(int[] nums){
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
            n ^= i;
        }
        return n;
    }

    @Test
    public void m1(){
        B b = new B();
        b.p1();
        b.p2();
    }

    class A{
        String a = "A";
    }

    class B extends A {
        String a = "B";

        void p1(){
            System.out.println(a);
        }

        void p2(){
            System.out.println(super.a);
        }
    }
}
