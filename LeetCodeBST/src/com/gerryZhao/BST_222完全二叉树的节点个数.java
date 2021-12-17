package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BST_222完全二叉树的节点个数
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-17 18:06
 * @Version 1.0.0
 */
public class BST_222完全二叉树的节点个数 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                res++;
            }
        }
        return res;
    }

    /**
     * 针对完全二叉树的解法
     * 满二叉树的结点数为: 2^depth + 1
     *
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes3(root.right);
        } else {
            return (1 << rightDepth) + countNodes3(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

}
