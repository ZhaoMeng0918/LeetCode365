package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BST_111二叉树的最小深度
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 16:41
 * @Version 1.0.0
 */
public class BST_111二叉树的最小深度 {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return ++res;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            res++;
        }
        return res;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth2(root.left);
        int rightDepth = minDepth2(root.right);
        // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
        if (root.left == null) return rightDepth + 1;
        if (root.right == null) return leftDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
