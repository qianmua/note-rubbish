package _java_array_to_tree_;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/3  15:37
 */
public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 数组转二叉树

    // 数组转平衡二叉树

    // 红黑树
    // ----

    @Test
    public void demo1T1(){
        System.out.println(15 << 1);
        System.out.println(22 >> 1);


        System.out.println(6 << 1);
        System.out.println( 18 >> 1);

        System.out.println( 10 & 1);
        System.out.println( 9 & 1);

        System.out.println(10 % 2);
        System.out.println(9 % 2);
    }


    @Test
    public void arrayToBinaryTree(){
        int[] arr = {1,2,3,4,5,6,7,8,9};

    }
    private TreeNode createTreeNode(Integer[] array){
        TreeNode root = createTreeNode(array , 1);
        return root;
    }

    // 递归 1
    private TreeNode createTreeNode(Integer[] array , int index){
        if (index > array.length){
            return null;
        }

        Integer v = array[index - 1];
        if (v == null){
            return null;
        }

        TreeNode node = new TreeNode(v);
        node.left = createTreeNode(array , index << 1);
        node.right = createTreeNode(array ,  index << 1 + 1);

        return node;
    }

    /**
     * 方法不一样 结果也不同
     */
    private TreeNode arrayToTreeNode(Integer[] array){
        if (array.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (Integer integer : array) {

            TreeNode node = queue.peek();

            if (isLeft) {
                if (integer != null) {
                    node.left = new TreeNode(integer);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {

                if (integer != null) {
                    node.right = new TreeNode(integer);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }

        }
        return root;
    }

    /**
     * AVL
     * 有序数组 ~
     */
    @Test
    public void arrayToBalanceBinaryTree(){
        int[] nums = {1,2,3,4,5,6};
        TreeNode treeNode = AVLLeft(nums, 0, nums.length - 1);
    }

    /**
     * 中序遍历 / 选择左元素为根节点
     */
    private TreeNode AVLLeft(int[] nums , int left , int right){
        if (left > right)
            return null;

        int p = (left + right) / 2;
        // 选择右元素
//        if ( ((left + right) & 1) == 1 )
//            ++p;
//
        TreeNode root = new TreeNode(nums[p]);
        root.left = AVLLeft(nums , left , p - 1);
        root.right = AVLLeft(nums , p + 1 , right);

        return root;
    }

    @Test
    public void redBlackTree(){

    }
}
