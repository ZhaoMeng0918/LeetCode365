package com.gerryZhao;

/**
 * @ClassName Node1
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-16 16:15
 * @Version 1.0.0
 */
public class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
