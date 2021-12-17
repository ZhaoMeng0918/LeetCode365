package com.gerryZhao;

import java.util.Stack;

/**
 * @ClassName BST_700二叉搜索树中的搜索
 * @Description 给定二叉搜索树(BST)的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。返回该节点为根的子树。
 * 如果节点不存在，则返回null。
 * @Author Administrator
 * @Date 2021-11-30 15:01
 * @Version 1.0.0
 */
public class BST_700二叉搜索树中的搜索 {
    /**
     * 1. 确定递归函数的参数和返回值
     * TreeNode* searchBST(TreeNode* root, int val)
     * 2. 确定终止条件
     * if (root == NULL || root->val == val) return root;
     * 3. 确定单层递归的逻辑
     * if (root->val > val) return searchBST(root->left, val); // 注意这里加了return
     * if (root->val < val) return searchBST(root->right, val);
     * return null;
     */
    // 递归
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode left = searchBST(root.left, val);
        if (left != null) return left;
        return searchBST(root.right, val);
    }

    // 递归，利用二叉搜索树的特点
    public static TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBST2(root.left, val);
        else return searchBST2(root.right, val);
    }

    // 迭代，普通二叉树
    public static TreeNode searchBST3(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val == val) return pop;
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
        return null;
    }

    // 迭代，利用二叉搜索树特点，优化
    public static TreeNode searchBST4(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        }
        return root;
    }
}
