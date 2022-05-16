package com.leetcode;

public class LeetCode_链表_24_两两交换链表中的节点 {
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

    public ListNode swapPairs(ListNode head) {
        ListNode header = new ListNode();
        header.next = head;
        ListNode prev = header;
        ListNode cur = null;
        while (prev.next != null && prev.next.next != null) {
            cur = prev.next;

            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;

            prev = cur;
        }
        return header.next;
    }
}
