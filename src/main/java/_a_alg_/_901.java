package _a_alg_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/10  23:44
 * @description :
 */
public class _901 {
    @Test
    public void m1(){

    }
    /*dp*/
    /*max 利润 */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if ( prices == null || length == 0){
            return 0;
        }
        // 天 状态(持有 / 未持有)
        int[][] dp = new int[length][2];
        // wu
        dp[0][0] = 0;
        // you
        dp[0][1] = 0 - prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1] , (i-2 > 0 ? dp[i-2][0] : 0) - prices[i]);
        }
        return Math.max(dp[length -1][0] , dp[length -1][1]);

    }
}
