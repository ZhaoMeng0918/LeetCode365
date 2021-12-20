package com.gerryZhao;

import java.util.Stack;

/**
 * @ClassName BST_110平衡二叉树
 * @Description 给定一个二叉树，判断它是否是高度平衡的二叉树
 * @Author Administrator
 * @Date 2021-12-20 16:22
 * @Version 1.0.0
 */
public class BST_110平衡二叉树 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();
            if (node.right == null || node.right == pre) {
                if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = node;
                root = null;
            } else {
                root = node.right;
            }
        }
        return true;
    }


}
