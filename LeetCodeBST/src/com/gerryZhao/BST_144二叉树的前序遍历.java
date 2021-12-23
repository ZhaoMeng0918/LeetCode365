package com.gerryZhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST_144二叉树的前序遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-22 20:13
 * @Version 1.0.0
 */
public class BST_144二叉树的前序遍历 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderTraversal(root, res);
        return res;
    }

    private void preOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrderTraversal(root.left, res);
        preOrderTraversal(root.right, res);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
