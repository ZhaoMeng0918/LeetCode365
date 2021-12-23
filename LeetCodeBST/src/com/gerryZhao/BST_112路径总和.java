package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BST_112路径总和
 * @Description 给你二叉树的根节点root和一个表示目标和的整数targetSum。判断该数中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和targetSum。如果存在，返回true，否则返回false；
 * @Author Administrator
 * @Date 2021-12-21 19:30
 * @Version 1.0.0
 */
public class BST_112路径总和 {
    /**
     * 递归
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null) return targetSum == 0;
        if (root.left != null) {
            if (hasPathSum1(root.left, targetSum)) {
                return true;
            }
        }
        if (root.right != null) {
            if (hasPathSum1(root.right, targetSum)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 回溯
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root, targetSum);
    }

    private boolean traversal(TreeNode root, int count) {
        if (root.left == null && root.right == null) return count == 0 ? true : false;
        if (root.left != null) {
            count -= root.left.val;
            if (traversal(root.left, count)) return true;
            count += root.left.val;
        }
        if (root.right != null) {
            count -= root.right.val;
            if (traversal(root.right, count)) return true;
            count += root.right.val;
        }
        return false;
    }

    /**
     * 迭代
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()) {
            int len = stack1.size();
            while (len-- > 0) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();
                if (node.left == null && node.right == null && sum == targetSum) return true;
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }
}
