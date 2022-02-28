package com.leetcode.linkedList;

/**
 * @ClassName LeetCode_203_移除链表元素
 * @Description 给你一个链表的头节点head和一个整数val，请你删除链表中所有满足Node.val == val的节点，并返回新的头节点 。
 * @Author Administrator
 * @Date 2022-02-26 15:03
 * @Version 1.0.0
 */
public class LeetCode_203_移除链表元素 {
    /**
     * 没有头节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode();
        header.next = head;
        if (header.next == null) return header.next;
        ListNode tmp = header;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return header.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
