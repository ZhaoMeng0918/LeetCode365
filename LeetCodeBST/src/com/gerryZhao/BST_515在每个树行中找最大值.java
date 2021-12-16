package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BST_515在每个树行中找最大值
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 16:10
 * @Version 1.0.0
 */
public class BST_515在每个树行中找最大值 {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int maxNum = Integer.MIN_VALUE;
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                maxNum = maxNum > node.val ? maxNum : node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            res.add(maxNum);
        }
        return res;
    }
}
