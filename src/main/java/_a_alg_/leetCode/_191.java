package _a_alg_.leetCode;

import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  12:51
 */
public class _191 {
    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     */

    @Test
    public void __191(){
        System.out.println(hmw2(1011));
    }

    private int hmw(int n){
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 0) {
                count ++;
            }
            n >>>= 1;
        }
        return count;
    }

    private int hmw2(int n){
        int count = 0;
        while (n!=0) {
            if ((n&1) == 1) {
                count++;
            }
            n>>>=1;
        }
        return count;
    }
}
