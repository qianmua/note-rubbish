package _a_alg_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/12  23:13
 * @description :
 */
public class _903 {

    @Test
    public void m1(){

    }
    // 二分法
    public int missingNumber(int[] nums) {
        // 有序 二分
        //
        int lef = 0 , rig = nums.length - 1;
        while (lef < rig){
            int mid = (lef + rig) / 2;
            if (nums[mid] != mid) {
                rig = mid;
            }else {
                lef = mid + 1;
            }
        }
        return lef == nums.length - 1 && nums[lef] == lef ? lef + 1 : lef;
    }
}
