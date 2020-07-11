package _a_alg_;

import org.junit.Test;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/11  22:53
 * @description :
 */
public class _902 {

    @Test
    public void m1(){

    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums , 0 , nums.length - 1);
    }

    public TreeNode help(int[] nums , int l , int r){
        if (l > r){
            return null;
        }
        int mid = (l+r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums , l , mid - 1);
        node.right = help(nums , mid + 1 , r);
        return node;
    }
}
