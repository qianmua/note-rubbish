package _a_alg_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/29  16:44
 * @description :
 */
public class _200 {

    @Test
    public void m1(){
        System.out.println(romaNum("MCCCXIV"));
    }
    int romaNum(String res){
        //i 1 v 5 x 10 l 50 c 100 d 500 m 100
        int sum = 0;
        if (res.length() == 0){
            return 0;
        }
        char[] chars = res.toCharArray();
        for (char re : chars) {
            if (re == 'I') sum += 1;
            if (re == 'V') sum += 5;
            if (re == 'X') sum += 10;
            if (re == 'L') sum += 50;
            if (re == 'C') sum += 100;
            if (re == 'D') sum += 500;
            if (re == 'M') sum += 1000;
        }
        // 去除歧义
        if (res.contains("IV")) sum -= 2;
        if (res.contains("IX")) sum -= 2;
        if (res.contains("XL")) sum -= 20;
        if (res.contains("XC")) sum -= 20;
        if (res.contains("CD")) sum -= 200;
        if (res.contains("CM")) sum -= 200;

        return sum;
    }

    @Test
    public void m2(){

    }
    int numMax(int arr[]){
        int sum = 0;
        return sum;
    }

    @Test
    public void m3(){
        m3_5();
    }
    void m3_3(){
        // 纳秒
        String s = System.nanoTime() + "";
        // 后8位
        s = s.substring(s.length() - 8);
//        System.out.println(s);
        System.out.println(Long.parseLong(s));
//        System.out.println(System.nanoTime());
    }

    void m3_4(){
        for (int i = 1; i < 100; i++) {
            StringBuilder temp = new StringBuilder(i+"");
            if (temp.length() < 6){
                int i2 = 6 - temp.length();
                temp.reverse();
                for (int i1 = 0; i1 < i2; i1++) {
                    temp.append(0+"");
                }
                temp.reverse();
            }
            System.out.println(temp.toString());
        }
    }

    void m3_5(){
        for (int i = 1; i < 100; i++) {
            System.out.println(String.format("%06d" , i));
        }
    }




}
