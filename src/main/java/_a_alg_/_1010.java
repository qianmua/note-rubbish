package _a_alg_;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/23  13:59
 * @description :
 */
public class _1010 {
    /**
     * 字符串匹配问题场景
     *
     * - 有一个字符串str1 = "abcdefg"  和 str2 = "def"
     * - 现在要判断str1 是否含有str2，如果存在，就返回第一次出现的位置，如果没有，则返回-1
     */

    @Test
    public void m1(){
        String s1 = "abcdefg";
        String s2 = "def";
        int i = s1.indexOf(s2);
        System.out.println(i);
    }


    List<Integer> list = new ArrayList<>();
    private void ss(int n , int c){

        while( c < n && n % c != 0 )
            // 最小 质数公约数
            c ++;

        if (c < n){
            list.add(c);
            // 商 的最小公约数
            ss(n / c , 2);
        }else
            list.add(c);

    }
}
