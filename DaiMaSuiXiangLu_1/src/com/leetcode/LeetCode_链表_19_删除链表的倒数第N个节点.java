package com.leetcode;

public class LeetCode_链表_19_删除链表的倒数第N个节点 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode header = new ListNode();
        header.next = head;
        ListNode slow = header;
        ListNode fast = header;
        while (n-- > 0) {
            fast = fast.next;
        }
        fast = fast.next; // fast先走一步
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return header.next;
    }
}
