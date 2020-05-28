package _算法与数据结构_._算法_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/27  19:21
 * @description :
 */
public class Demo4 {

    /*
    * 二分搜索
    *
    * 贪婪算法
    *
    *
    * */


    // 二分搜索
    int binarySearch(int[] arr , int target , int s , int e){

        if (s > e) return -1;

        int mid = s + (e-s) / 2; // 防止 溢出

        if ( arr[mid] == target) return mid;

        if ( target < arr[mid]){
            return binarySearch(arr ,target , s , mid -1 );
        }else {
            return binarySearch(arr , target , mid + 1 , e);
        }
    }


    /*
    *
    * 贪婪 算法
    *
    *
    * 反例 ： 背包问题
    *
    * 仅对 局部 最优 适合
    *
    * */
}
