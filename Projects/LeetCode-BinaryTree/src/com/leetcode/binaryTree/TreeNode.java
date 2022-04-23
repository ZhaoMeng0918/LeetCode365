package com.leetcode.binaryTree;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author Administrator
 * @Date 2022-03-07 10:43
 * @Version 1.0.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
