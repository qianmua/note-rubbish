package _a_alg_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/23  22:03
 * @description :
 */
public class J11DoublePower {

    @Test
    public void m1(){
        System.out.println( 4 & 0x1 ); // 0
        System.out.println( 3 & 0x1 ); // 1
    }

    // 数值的整数次方
    private double powerWithExponent(double var1 , int var2){

        /*
            偶数
            an/2 * an/2

            奇数
            a(n-1)/2 * a(n-12)/2 * a

         */

        if (var2 == 0)
            return 1;
        if (var2 == 1){
            return var1;
        }

        double res = powerWithExponent(var1 , var2 >> 1);
        res *= res;

        if ( (var2 & 0x1) == 1){ // 奇数
            res *= var1;
        }

        return res;
    }
}
