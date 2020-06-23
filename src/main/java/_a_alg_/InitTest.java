package _a_alg_;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/23  22:00
 * @description :
 */
public class InitTest {

    @Test
    public void m1(){
        int[] arr = {1,17,5,10,13,15,10,5,16,8};
        //  - + - - - + + - +
        int a = wiggleMaxLength(arr);
    }

    private int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        System.out.println(up);
        System.out.println(down);
        return Math.max(up, down);
    }


    @Test
    public void m2(){
        String a = "11", b = "1";
        String s = addBinary(a, b);
//        System.out.println(s);
        add2();
    }

    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int x=0;
        int y=0;
        int pre=0;//进位
        int sum=0;//存储进位和另两个位的和

        while(a.length()!=b.length()){//将两个二进制的数位数补齐,在短的前面添0
            if(a.length()>b.length()){
                b="0"+b;
            }else{
                a="0"+a;
            }
        }
        for(int i=a.length()-1;i>=0;i--){
            x=a.charAt(i)-'0';
            y=b.charAt(i)-'0';
            sum=x+y+pre;//从低位做加法
            if(sum>=2){
                pre=1;//进位
                sb.append(sum-2);
            }else{
                pre=0;
                sb.append(sum);
            }
        }
        if(pre==1){
            sb.append("1");
        }
        return sb.reverse().toString();//翻转返回
    }

    public void add2(){
        long a = Integer.parseInt("0b11");
        long b = 0b1;
        System.out.println(a);
    }
}
