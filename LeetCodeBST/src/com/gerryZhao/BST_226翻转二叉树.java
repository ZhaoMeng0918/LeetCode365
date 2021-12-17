package com.gerryZhao;

import java.util.ArrayDeque;

/**
 * @ClassName BST_226翻转二叉树
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-17 16:12
 * @Version 1.0.0
 */
public class BST_226翻转二叉树 {
    /**
     * DFS递归
     * 前后序都可，中序不可（因为先左孩子交换孩子，再根交换孩子，完成后右孩子已经变成原来的左孩子）
     *
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        invertTree1(root.left);
        invertTree1(root.right);
        swapChildern(root);
        return root;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            while (len-- > 0) {
                TreeNode node = deque.poll();
                swapChildern(node);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return root;
    }

    private void swapChildern(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = node.left;
    }
}
