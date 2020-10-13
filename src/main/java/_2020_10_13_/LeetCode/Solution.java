package _2020_10_13_.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<TreeNode>> allTrace = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return res;
        }

        List<TreeNode> trace = new ArrayList<>();
        dfs(root, trace);


        for(List<TreeNode> list:allTrace){
            int count = 0;
            for(TreeNode node: list){
                count += node.val;
            }
            if(count == sum){
                List<Integer> temp = new ArrayList<>();
                for(TreeNode node: list){
                    temp.add(node.val);
                }
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }

    public void dfs(TreeNode root, List<TreeNode> trace){
        if(root == null){
            return;
        }
        trace.add(root);
        if(root.left == root.right){
            allTrace.add(new ArrayList<>(trace));
            trace.remove(root);
            return;
        }

        dfs(root.left,trace);
        dfs(root.right, trace);
        trace.remove(trace.size()-1);
        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(8);
        TreeNode root4 = new TreeNode(11);
        TreeNode root5 = new TreeNode(13);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(2);
        TreeNode root9 = new TreeNode(5);
        TreeNode root10 = new TreeNode(1);

        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root3.left = root5;
        root3.right = root6;
        root4.left = root7;
        root4.right = root8;
        root6.left = root9;
        root6.right = root10;

        TreeNode root0 = new TreeNode(1);

        Solution solution = new Solution();
        solution.pathSum(root, 22);

    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }