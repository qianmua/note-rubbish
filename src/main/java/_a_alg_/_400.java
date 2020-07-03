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


    @Test
    public void m2(){
        // 最小 子数组

        // 双指针 应用
        // 标记 一段 范围
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    int m2_2(int s , int[] nums){
        int l = -1,r = -1;
        int sum = 0, min = Integer.MAX_VALUE;
        int len = nums.length;
        while (l <= r) {
            if (sum < s){
                r ++;
                if (r>= len)
                    break;
                sum += nums[r];
            }else {
                if (r - l < min){
                    min =  r - l;
                }
                l++;
                if (l > r)break;
                sum -= nums[l];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length <= 0) return 0;
        int minL = -1;
        int i1 = nums.length;
        int f = 0;
        int e = 0;
        int temp = 0;
        for (int i = 0; i < i1 ; i++) {
            if (nums[i] >= s){
                return 1;
            }else {
                temp += nums[i];
                e++;
                if (temp >= s){
                    temp = 0;
                    minL = minL == -1 ? e-f : minL < e-f ? minL : e-f ;
                    f = e;
                }
            }
        }
        return minL;
    }
}
