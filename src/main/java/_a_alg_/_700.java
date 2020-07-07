package _a_alg_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/7  23:16
 * @description :
 */
public class _700 {

    @Test
    public void m1(){

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum-root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) ||
        hasPathSum(root.right, sum - root.val);
    }
}
