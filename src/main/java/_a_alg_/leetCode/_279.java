package _a_alg_.leetCode;

import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  9:40
 */
public class _279 {

    /**
     * 任何正整数都可以拆分成不超过4个数的平方和 ---> 答案只可能是1,2,3,4
     * 如果一个数最少可以拆成4个数的平方和，则这个数还满足 n = (4^a)*(8b+7) ---> 因此可以先看这个数是否满足上述公式，如果不满足，答案就是1,2,3了
     * 如果这个数本来就是某个数的平方，那么答案就是1，否则答案就只剩2,3了
     * 如果答案是2，即n=a^2+b^2，那么我们可以枚举a，来验证，如果验证通过则答案是2
     * 只能是3
     */

    @Test
    public void 完全平方数_279() {

    }

    private int sum(int n){
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;  // 当目标值为i时，最多由i个1相加而成
            for (int j = 1; j * j <= i; j++) {
                /*
                    当目标值为i时，可能是由：
                        1、之前的计算结果
                        2、j(平方小于i) 的组成个数，加上“j”这1个数
                */
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }

}
