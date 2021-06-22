package _a_alg_.leetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  13:51
 */
public class _260 {

    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     */

    @Test
    public void __260(){
        //  3 5
        int a = 3;
        int b = 5;
        System.out.println(Arrays.toString(sn(new int[]{a, b, 1 , 2 ,1 , 2})));
    }

    private int[] sn(int[] nums){
        int a = 0;
        int b = 0;
        return new int[]{a , b};
    }
}
