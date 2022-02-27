package com.leetcode.linkedList;

/**
 * @ClassName LeetCode_24_两两交换链表中的节点
 * @Description 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头结点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * @Author Administrator
 * @Date 2022-02-26 15:04
 * @Version 1.0.0
 */
public class LeetCode_24_两两交换链表中的节点 {
    static class ListNode {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode header = new ListNode(0);
        header.next = head;

        ListNode prev = header;
        ListNode cur = head;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = temp;
            prev = cur;
            cur = cur.next;
        }

        return header.next;
    }
}
