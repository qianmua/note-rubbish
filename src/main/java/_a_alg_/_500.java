package _a_alg_;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/4  23:40
 * @description :
 */
public class _500 {

    @Test
    public void m1(){
        System.out.println(findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest1(int[] nums, int k) {
        //List<Integer> collect = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int[] ints = Arrays.stream(nums).sorted().toArray();
        return ints[ints.length-k];
    }
    public int findKthLargest(int[] nums, int k) {
        // 使用 优先 队列
        // 越小 的 插入 在前面
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            if (heap.size() < k){
                heap.add(i);
            }else if (heap.peek() < i){
                heap.poll();
                heap.add(i);
            }
        }
        return heap.poll();
    }

    public int findKthLargest3(int[] nums, int k) {
        // 快速 排序
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) return nums[l];
        int i = l - 1, j = r + 1;
        int x = nums[l + r >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);
        }
        if (r - j >= k) return quickSort(nums, j + 1, r, k);
        return quickSort(nums, l, j, k - (r - j));
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
