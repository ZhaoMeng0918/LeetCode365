package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BST_102二叉树的层序遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 15:05
 * @Version 1.0.0
 */
public class BST_102二叉树的层序遍历 {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            res.add(tmpList);
        }
        return res;
    }
}
