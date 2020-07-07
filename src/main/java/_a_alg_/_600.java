package _a_alg_;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/5  23:10
 * @description :
 */
public class _600 {

    @Test
    public void m1(){
        // r b w
        // 0 1 2
        // 1 排序
        // 2 一次 遍历over
        // 双指针
        int[] ints = {2, 0, 2, 1, 1, 0 };
        sortColors(ints);
    }

    public void sortColors(int[] nums) {
        int arr[] = nums.clone();
        int f = -1,n = nums.length;
        for (int value : arr) {
            if (value == 0) {
                nums[f+1] = 0;
                f++;
            }
            else if (value == 2) {
                nums[n-1] = 2;
                n--;
            }
        }
        for (int i = f+1; i < n; i++) {

            nums[i] = 1;
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }

    @Test
    public void m2(){
        int a = 7;
        int temp = 0;
        a |= a >> 1;
        a |= a >> 2;
        a |= a >> 4;
        a |= a >> 8;
        a |= a >> 16;
//        a |= a >> 32;
//        a |= a >> 64;
        System.out.println(a+1);
    }
}
