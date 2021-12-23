package com.gerryZhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST_94二叉树的中序遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-22 20:14
 * @Version 1.0.0
 */
public class BST_94二叉树的中序遍历 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderTraversal(root.left, res);
        res.add(root.val);
        inOrderTraversal(root.right, res);
    }

    /**
     * 迭代
     * 问题代码
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                res.add(node.val);
                if (node.right !=null) stack.push(node.right);
            }
        }
        return res;
    }

    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 一路走到left叶子结点
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inorderTraversal2(root);

    }
}
