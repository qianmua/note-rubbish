package _a_alg_.leetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/16  16:29
 * @description :
 */
public class _1486 {

    /**
     * 给你两个整数，n 和 start 。
     *
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     *
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     */

    @Test
    public void m1(){
//        int xor = xor(5, 0);
        int xor = xor(4, 3);
        System.out.println(xor);
    }

    private int xor( int n , int s){

        if (n == 1)
            return s;

        int r = s;
        for (int i = 1; i < n; i++) {
            r ^= (s + 2 * i);
        }

        return r;
    }


    @Test
    public void m2(){
        int[] arr = {1, 3, 7, 8};
        int[] num = getTargetNum(arr, 10);
        System.out.println(Arrays.toString(num));
    }
    public int[] getTargetNum(int arr[] , int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            map.put(arr[i] , i);

        for (int i : arr) {
            if (map.containsKey(target - i))
                return new int[]{map.get(i)+1 , map.get(target - i) + 1};
        }
        return null;
    }


}
