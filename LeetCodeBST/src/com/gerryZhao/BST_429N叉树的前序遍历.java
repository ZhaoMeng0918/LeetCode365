package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BST_429N叉树的前序遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 16:01
 * @Version 1.0.0
 */
public class BST_429N叉树的前序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        /**
         * 层序遍历法
         */
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                Node node = queue.poll();
                tmpList.add(node.val);
                len--;
                if (node.children != null) {
                    List<Node> childrens = node.children;
                    for (Node n : childrens) {
                        queue.offer(n);
                    }
                }
            }
            res.add(tmpList);
        }
        return res;
    }
}
