package _算法与数据结构_._算法_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/27  16:43
 * @description :
 */
public class Demo1 {

    /*
    * 递归
    * 回溯
    * */

    // 排序

    private static void sort(int[] arr){
        boolean b = true;

        for (int i = 0; i < arr.length -1 && b; i++) {
            b = false;
            for (int i1 = 0; i1 < arr.length - 1 -i; i1++) {
                if (arr[i1] > arr[i1 + 1]){
                    // swap
                    b = true;
                }
            }
        }
    }

    // 插入 排序
    private static void insert(int[] nums){
        for (int i = 1 , j , count; i < nums.length; i++) {
            count = nums[i];
            for ( j = i - 1; j >= 0 && nums[j] > count ; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = count;

        }

    }

    // 归并 排序
    void guib(int[] arr , int s , int e){
        if (s >= e) return ;

        int mid  = s + (e - s) / 2;

        guib(arr , s , mid);
        guib(arr , mid + 1 , e);

        // 合并
        heb(arr , s , mid , e);
    }
    void heb(int[] arr , int s , int mid , int e){
        int[] copt = arr.clone();
        int k  = s , i = e , j = mid + 1;

        while (k <= e){
            if (i > mid){
                arr[k++] = copt[j++];
            }else if (j > e){
                arr[k++] = copt[i++];
            }else if (copt[j] < copt[i]){
                arr[k++] = copt[j++];
            }else {
                arr[k++] = copt[i++];
            }
        }
    }


}
