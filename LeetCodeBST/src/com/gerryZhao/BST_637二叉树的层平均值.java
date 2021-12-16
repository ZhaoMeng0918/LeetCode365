package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BST_637二叉树的层平均值
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 15:32
 * @Version 1.0.0
 */
public class BST_637二叉树的层平均值 {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int tmpLen = len;
            double sum = 0;
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                sum += node.val;
                len--;
            }
            sum /= tmpLen;
            res.add(sum);
        }
        return res;
    }
}
