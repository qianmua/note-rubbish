package _a_alg_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/28  23:27
 * @description :
 */
public class _100 {

    @Test
    public void m1(){
        String s = "666.jpg";
        int i = s.lastIndexOf('.');
        String s1 = s.substring(i);
        System.out.println(s1);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left , q.left) && isSameTree(p.right, q.right);
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
