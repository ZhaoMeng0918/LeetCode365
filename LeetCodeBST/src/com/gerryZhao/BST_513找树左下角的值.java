package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BST_513找树左下角的值
 * @Description 给定一个二叉树的根结点root，请找出该二叉树的最底层最左边结点的值。
 * @Author Administrator
 * @Date 2021-12-21 19:08
 * @Version 1.0.0
 */
public class BST_513找树左下角的值 {
    /**
     * 层序遍历
     * 先最底层，再最左层
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue1(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            res = queue.peek().val;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    private int Deep = -1;
    private int value = 0;

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left, deep + 1);
        if (root.right != null) findLeftValue(root.right, deep + 1);
    }
}
