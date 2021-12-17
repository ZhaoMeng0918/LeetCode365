package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BST_104二叉树的最大深度
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 16:36
 * @Version 1.0.0
 */
public class BST_104二叉树的最大深度 {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            res++;
        }
        return res;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
