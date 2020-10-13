package _2020_10_13_.LeetCode;

public class NetherLand {
    public static void sortColors(int[] nums) {
        if(nums==null || nums.length<=1){
            return;
        }
        int len = nums.length;
        int left=0, right=len-1, cur=0;

        while(nums[left]==0){
            left++;
            cur++;
        }

        while(nums[right]==2){
            right--;
        }

        while(cur<=right){
            if(nums[cur]==0){
                swap(nums,left,cur);
                left++;
                cur++;
            }else if(nums[cur]==2){
                swap(nums,cur,right);
                right--;
            }else{
                cur++;
            }
        }

    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
    }
}
