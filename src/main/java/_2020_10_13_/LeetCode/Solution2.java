package _2020_10_13_.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        int first = k-1;
        int second = 0;
        int[] ans = new int[nums.length-k+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nums[0]);
        for(int i=1; i<k; i++){
            while(!queue.isEmpty() && queue.peek()<nums[i]){
                queue.poll();
            }
            queue.offer(nums[i]);
        }
        ans[second] = queue.peek();
        while(first<nums.length-1){
            if(nums[second] == queue.peek()){
                queue.poll();
            }
            second++;
            first++;

            while(!queue.isEmpty() && nums[first]>queue.peek()){
                queue.poll();
            }
            queue.offer(nums[first]);
            ans[second] = queue.peek();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        maxSlidingWindow(nums,3);
    }
}
