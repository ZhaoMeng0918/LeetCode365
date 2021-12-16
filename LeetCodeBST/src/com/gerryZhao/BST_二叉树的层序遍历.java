package com.gerryZhao;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BST_二叉树的层序遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-11 11:14
 * @Version 1.0.0
 */
public class BST_二叉树的层序遍历 {
    private List<List<Integer>> res = new ArrayList<>();
    /**
     * 递归
     *
     * @param node
     * @param deep
     */
    private void recursionTraversal(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;
        if (res.size() < deep) {
            // 当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            res.add(item);
        }
        res.get(deep - 1).add(node.val);
        recursionTraversal(node.left, deep);
        recursionTraversal(node.right, deep);
    }

    private void queueTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            res.add(list);
        }
    }
}
