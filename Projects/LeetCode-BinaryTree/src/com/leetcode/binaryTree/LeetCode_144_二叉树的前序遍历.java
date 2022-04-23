package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName LeetCode_144_二叉树的前序遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2022-03-07 10:44
 * @Version 1.0.0
 */
public class LeetCode_144_二叉树的前序遍历 {
    /**
     * 递归遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }

    /**
     * 迭代遍历
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
            if (node.left != null) {
                stack.push(node.right);
            }
            if (node.right != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
