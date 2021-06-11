package _a_alg_.leetCode;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  10:00
 */
public class _137 {
    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     */

    /**
     * 假设有一个数为x,那么则有如下规律：
     * 0 ^ x = x,
     *
     * x ^ x = 0；
     *
     * x & ~x = 0,
     *
     * x & ~0 =x;
     *
     * -那么就是很好解释上面的代码了。一开始a = 0, b = 0;
     *
     * x第一次出现后，a = (a ^ x) & ~b的结果为 a = x, b = (b ^ x) & ~a的结果为此时因为a = x了，所以b = 0。
     *
     * x第二次出现：a = (a ^ x) & ~b, a = (x ^ x) & ~0, a = 0; b = (b ^ x) & ~a 化简， b = (0 ^ x) & ~0 ,b = x;
     *
     * x第三次出现：a = (a ^ x) & ~b， a = (0 ^ x) & ~x ,a = 0; b = (b ^ x) & ~a 化简， b = (x ^ x) & ~0 , b = 0;所以出现三次同一个数，a和b最终都变回了0.
     *
     * 只出现一次的数，按照上面x第一次出现的规律可知a = x, b = 0;因此最后返回a.
     *
     */

    public int sn(int[] nums){
        int v = 0 , v1 = 0;
        for (int num : nums) {
            v = ( v ^ num) & ~ v1;
            v1 = ( v1 ^ num) & ~v;
        }

        return v;
    }
}
