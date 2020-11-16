package _a_alg_.leetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/16  16:35
 * @description :
 */
public class _215 {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */

    //  [3,2,1,5,6,4] 和 k = 2

    @Test public void m1(){
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        sort(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[arr.length-k]); // 5

    }

    private void sort(int[] arr , int s , int e){

        if (s > e)
            return ;

        int l = s;
        int r = e;

        int mid = arr[l];

        while (l < r){

            while (l < r && arr[r] >= mid)
                r--;

            arr[l] = arr[r];

            while (l < r && arr[l] < mid)
                l ++;

            arr[r] = arr[l];

        }

        arr[l] = mid;

        sort(arr , s , l - 1);
        sort(arr , l + 1 , e);

    }
}
