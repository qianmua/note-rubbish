package _a_alg_;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/1  22:18
 * @description :
 */
public class _905 {

    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * dp
     *
     */

    @Test
    public int jump(int n){
        if (n <= 2)
            return n;
        int p1 = 1, p2 = 2 , res = 1;
        for (int i = 2; i < n; i++) {
            res = p1 + p2;
            p2 = p1;
            p1 = res;
        }
        return res;
    }

    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * dp
     */

    @Test
    public int jump2(int n){
        int[] dp = new int[n];
        // init
        Arrays.fill(dp , 1);

        for (int i = 1; i < n; i++) {
            for (int i1 = 0; i1 < i; i1++) {
                dp[i] += dp[i1];
            }
        }
        return dp[n-1];
    }

}
