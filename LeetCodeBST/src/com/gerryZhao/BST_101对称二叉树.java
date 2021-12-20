package com.gerryZhao;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName BST_101对称二叉树
 * @Description 本题只能是后序遍历
 * @Author Administrator
 * @Date 2021-12-17 16:30
 * @Version 1.0.0
 */
public class BST_101对称二叉树 {
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return false;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;
        // boolean compareOutside = compare(left.left, right.right);
        // boolean compareInside = compare(left.right, right.left);
        // return compareOutside && compareInside;
        // 优化
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    /**
     * 迭代法
     * 使用双端队列，相当于两个栈
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (left == null && right != null) return false;
            if (left != null && right == null) return false;
            if (left == null && right == null) return true;
            if (left.val != right.val) return false;
            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerLast(right.left);
        }
        return true;
    }
}
