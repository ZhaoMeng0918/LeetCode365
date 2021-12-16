package com.gerryZhao;

import java.util.ArrayList;

/**
 * @ClassName BST_二叉树递归遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-11 11:13
 * @Version 1.0.0
 */
public class BST_二叉树递归遍历 {
    /**
     * 前序遍历
     *
     * @param root
     * @param result
     */
    public void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param result
     */
    public void inOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param result
     */
    public void postOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
