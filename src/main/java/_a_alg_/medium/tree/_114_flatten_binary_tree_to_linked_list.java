package _a_alg_.medium.tree;

/**
 * @Author: rtliu
 * @Date: 2020/7/31 下午2:03
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given a binary tree, flatten it to a linked list in-place.
 * `          For example, given the following tree:
 * `                      1
 * `                     / \
 * `                    2   5
 * `                   / \   \
 * `                  3   4   6
 * `          The flattened tree should look like:
 * `                  1
 * `                   \
 * `                    2
 * `                     \
 * `                      3
 * `                       \
 * `                        4
 * `                         \
 * `                          5
 * `                           \
 * `                            6
 * @Version: 1.0
 */
public class _114_flatten_binary_tree_to_linked_list {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        flatten(left);
        flatten(right);

        root.right = left;

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }

}
