package _a_alg_;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/30  23:26
 * @description :
 */
public class _300 {

    @Test
    public void m1(){

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        n -=n;
        int i = n + m;
        m -= m;
        while(n>=0) {
            nums1[i--] = m>=0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }


    @Test
    public void m2(){
        int dp = dp(5);
        System.out.println(dp);
    }

    int dp(int n){
        if (n <= 0) return 1;
        return n * dp(n - 1);
    }


}
