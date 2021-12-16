package com.gerryZhao;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author Administrator
 * @Date 2021-11-30 15:07
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
