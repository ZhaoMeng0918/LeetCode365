package com.gerryZhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BST_117填充每个节点的下一个右侧节点指针II
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 16:33
 * @Version 1.0.0
 */
public class BST_117填充每个节点的下一个右侧节点指针II {
    /**
     * 层序遍历法
     *
     * @param root
     * @return
     */
    public Node1 connect(Node1 root) {
        if (root == null) return root;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                Node1 node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
                if (len > 0) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }
            }
        }
        return root;
    }
}
