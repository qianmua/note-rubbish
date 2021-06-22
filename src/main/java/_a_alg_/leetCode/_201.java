package _a_alg_.leetCode;

import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  13:19
 */
public class _201 {

    /**
     * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
     */

    @Test
    public void __201(){

    }

    /**
     * 当一个数+1时，总会有这么一个规律“某一位后的数字，全部被置为相反数”。举个例子：
     *
     * 010111 + 1 = 011000，则010111 & 011000 = 010000。那么，x & (x+1) 后几位相反数的“与操作”，结果总为0。
     * 所以，当(m,m+1,...n-1,n)进行连续“与操作”时，会按照上述规律被抵消很大一部分，而只剩下n的前缀部分，最后只需将n归位。举个例子：
     *
     * m = 5(0101), n = 7 (0111)。不停右移，得到n前缀部分为01，最后归位前缀得res=0100=4
     */
    private int rbwa(int left , int right){
        int offset = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            ++offset;
        }
        return right << offset;
    }
}
