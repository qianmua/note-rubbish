package _a_alg_;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void m2(){

    }
    List<List<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> d = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return lists ;
        sum -= root.val;
        d.add(root.val);

        dfs(root , sum);
        return lists;
    }
    void dfs(TreeNode r ,int sum){
        if (r.left == null && r.right == null){
            if (sum == 0){
                lists.add(new ArrayList<>(d));
            }
            return;
        }
        //
        if (r.left != null){
            d.add(r.left.val);
            dfs(r.left , sum -r.left.val);
            d.remove(d.size() - 1);
        }
        if (r.right != null){
            d.add(r.right.val);
            dfs(r.right , sum -r.right.val );
            d.remove(d.size() - 1);
        }
    }




}
