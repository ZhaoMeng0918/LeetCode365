package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BST_599N叉树的最大深度
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-17 16:49
 * @Version 1.0.0
 */
public class BST_599N叉树的最大深度 {
    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        int res = 0;
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                Node node = queue.poll();
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null) queue.offer(node.children.get(i));
                }
            }
            res++;
        }
        return res;
    }

    public int maxDepth2(Node root) {
        int res = 0;
        if (root == null) return res;
        if (root.children != null)
            for (Node child : root.children)
                // 递归的求出每个子树的高度，求的最大值
                res = Math.max(res, maxDepth2(child));
        return res + 1;
    }
}
