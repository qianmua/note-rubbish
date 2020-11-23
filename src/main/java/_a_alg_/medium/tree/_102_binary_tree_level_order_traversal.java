package _a_alg_.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/27 下午4:07
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given a binary tree, return the level order traversal of its nodes' values.
 * `          (ie, from left to right, level by level).
 * `          For example: Given binary tree [3,9,20,null,null,15,7],
 * `                      3
 * `                     / \
 * `                    9  20
 * `                      /  \
 * `                     15   7
 * `         return its level order traversal as:
 * `              [
 * `                  [3],
 * `                  [9,20],
 * `                  [15,7]
 * `              ]
 * @Version: 1.0
 */
public class _102_binary_tree_level_order_traversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(7);
        levelOrder(treeNode);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        backTrace(answer, 0, root);
        return answer;
    }


    private static void backTrace(List<List<Integer>> answer, int depth, TreeNode root) {
        if (root == null) {
            return;
        }

        if (answer.size() > depth) {
            answer.get(depth).add(root.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            answer.add(new ArrayList<>(list));
        }

        backTrace(answer, depth + 1, root.left);
        backTrace(answer, depth + 1, root.right);

    }
}
