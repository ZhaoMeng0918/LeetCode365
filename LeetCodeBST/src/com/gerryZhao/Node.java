package com.gerryZhao;

import java.util.List;

/**
 * @ClassName Node
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 16:03
 * @Version 1.0.0
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
