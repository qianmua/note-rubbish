package _2020_10_13_.LeetCode;

/**
 * 二分查找
 * @author ACER
 */
public class BinarySearch {
    public static int search(int[] a, int target){
        int len = a.length;
        int lo = 0, hi = len-1;
        return search(a, target, lo, hi);
    }

    public static int search(int[] a, int target, int lo, int hi){
        int mid = lo + (hi -lo) / 2;
        if(lo > hi){
            return -1;
        }
        if(a[mid] > target){
            return search(a, target, lo, mid-1);
        }else if(a[mid] < target){
            return search(a, target, mid+1, hi);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] src = new int[10];
        for(int i=0; i<10; i++){
            src[i] = 2*i;
        }
        int ans = search(src, 8);
        System.out.println(ans);
    }
}
