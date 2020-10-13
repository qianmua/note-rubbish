package _2020_10_13_.LeetCode;

/**
 * 快速排序
 * @author ACER
 */
public class QuickSort {
    public static void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    public static void sort(int[] a, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int j = partitiion(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partitiion(int[] a, int lo, int hi) {
        int i=lo+1, j=hi;
        int a0 = a[lo];
        while (true){
            while (a[i] <= a0){
                i++;
                if(i == hi){
                    break;
                }
            }
            while (a[j] > a0){
                j--;
                if(j ==lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[j];
        a[j] = a[lo];
        a[lo] = temp;
        return j;
    }


    public static void main(String[] args) {
        int[] src = new int[]{10,8,5,6,14,20,48,56,24,78,99,1,24,214,22,14,26,48,79,45,57,22,56};
        sort(src);
        System.out.println("000");
    }

}
