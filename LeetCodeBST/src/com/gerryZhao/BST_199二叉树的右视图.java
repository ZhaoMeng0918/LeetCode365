package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BST_199二叉树的右视图
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 15:18
 * @Version 1.0.0
 */
public class BST_199二叉树的右视图 {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
                if (len == 0) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
