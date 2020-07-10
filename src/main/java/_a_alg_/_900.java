package _a_alg_;

import org.junit.Test;

import javax.validation.constraints.Max;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/9  22:32
 * @description :
 */
public class _900 {

    @Test
    public void m1(){

    }
    /* 记住 前面 最长的 串*/
    /* 指针标识*/
    public int respace(String[] dictionary, String sentence) {
        int length = sentence.length();
        int[] dp = new int[length+1];
        int rig = 1;
        while (rig <= length){
            dp[rig] = dp[rig-1];
            for (String s : dictionary) {
                int length1 = s.length();
                // 越界
                if (rig < length1){
                    // 不匹配
                    continue;
                }
                // 截取
                String s1 = sentence.substring(rig - length1, rig);
                if (!s1.equals(s)){
                    // 不匹配
                    continue;
                }
                // 相同
                dp[rig] = Math.max(dp[rig] , dp[rig - length1] + length1);
            }
            rig++;
        }
        return length - dp[length];
    }
}
