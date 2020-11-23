package _a_alg_;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/23  22:15
 * @description :
 */
public class J12PrintMaxNum {

    // 打印1到最大的n位数

    @Test
    public void jm1(){
        //n
        int n = 3; // print 1 2 3 .... 999


        int[] arr = {1,234,354,654,75678,6867,867,45,64,534,234,254,};

        quickSort(arr , 0 ,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void printMaxNum(int n){

        // 注意溢出问题

    }

    // 在交换左右指针的时候只需要先后覆盖就可以了。这样既能减少空间的使用还能降低赋值运算的次数
    private void quickSort(int[] arr , int v1 , int v2){
        if (v1 >= v2)
            return ;

        int l = v1 , r = v2, m  = arr[v1];

        // 分治
        // 二分

        while (l < r){
            while (l < r && arr[r] > m)
                r--;

            arr[l] = arr[r];

            while (l < r && arr[l] <= m)
                l ++;

            arr[r] = arr[l];

        }

        arr[l] = m;
        quickSort(arr , v1 , l - 1); // 左
        quickSort(arr , l + 1 , v2); // 右

    }
}
