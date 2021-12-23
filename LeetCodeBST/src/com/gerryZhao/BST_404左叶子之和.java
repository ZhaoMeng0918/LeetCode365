package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BST_404左叶子之和
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-21 18:49
 * @Version 1.0.0
 */
public class BST_404左叶子之和 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        int leftVal = sumOfLeftLeaves1(root.left);
        int rightVal = sumOfLeftLeaves1(root.right);
        int midVal = 0;
        if (root.left != null && root.left.left != null && root.left.right != null) {
            midVal = root.left.val;
        }
        return midVal + leftVal + rightVal;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left != null && node.left.right != null) {
                res += node.left.val;
            }
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return res;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves3(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left != null && node.left.left != null && node.left.right != null) {
                        res += node.left.val;
                    }
                }
                if (node.right != null) queue.offer(root.right);
            }
        }
        return res;
    }
}
