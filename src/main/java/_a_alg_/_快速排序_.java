package _a_alg_;

import java.util.Arrays;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/16  16:06
 * @description :
 */
public class _快速排序_ {


    public static void main(String[] args) {
        // 快排
        int[] arr = new int[]{213,345,546,547,6576,86789,78,87980,122,27,34,14,6,78,9,84,567,43,657,123,45};
        quick(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quick(int[] arr, int s, int e){

        if (s >= e)
            return ;

        int left = s;
        int right = e;

        int mid = arr[left];

        while (left < right){
            while (left < right && arr[right] >= mid)
                right--;

            // swap
            arr[left] = arr[right];

            while (left < right && arr[left] <mid)
                left ++;

            arr[right] = arr[left];
        }

        arr[left] = mid;

        quick(arr, s, left -1);
        quick(arr , left+1 , e);

    }

}
