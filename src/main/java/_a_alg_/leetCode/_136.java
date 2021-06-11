package _a_alg_.leetCode;

import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  9:46
 */
public class _136 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    @Test
    public void m1(){

    }
    private int sn(int[] nums){
        int v = 0;
        for (int num : nums) {
            v ^= num;
        }
        return v;
    }
}
