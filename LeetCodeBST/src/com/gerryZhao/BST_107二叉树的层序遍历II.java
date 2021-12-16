package com.gerryZhao;

import java.util.*;

/**
 * @ClassName BST_107二叉树的层序遍历II
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 15:13
 * @Version 1.0.0
 */
public class BST_107二叉树的层序遍历II {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res);
        return res;
    }
}
