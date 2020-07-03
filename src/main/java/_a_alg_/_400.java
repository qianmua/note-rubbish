package _a_alg_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/3  22:08
 * @description :
 */
public class _400 {

    @Test
    public void m1(){
        // 背包问题

        // 性价比
        // 单位体积

        // 物品：
            //拿 / 不拿
        int[] w = {5,6,10,9};
        int[] v = {200,66,100,72};
        int maxW = 20;
        int vNum = 4;

        System.out.println(dp( maxW , vNum, w, v));
    }

    public int dp(int maxW , int vNum , int[] w , int[] v){
        int[][] ints = new int[maxW + 1][vNum + 1];
        for (int i = 1 ; i <= vNum ;i ++){
            int i1 = v[i - 1];
            int i2 = w[i - 1];
            for (int j = 1 ; j<= maxW ; j++){
                if (j < i2){
                    ints[j][i] = ints[j][i-1];
                    continue;
                }
                ints[j][i] = Math.max(ints[j][i-1] , ints[j-i2][i-1] + i1);
            }
        }
        return ints[maxW][vNum];
    }
}
