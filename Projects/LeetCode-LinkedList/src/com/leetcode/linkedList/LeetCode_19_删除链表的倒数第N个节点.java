package com.leetcode.linkedList;

/**
 * @ClassName LeetCode_19_删除链表的倒数第N个节点
 * @Description 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * @Author Administrator
 * @Date 2022-02-26 15:05
 * @Version 1.0.0
 */
public class LeetCode_19_删除链表的倒数第N个节点 {
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
    /**
     * 双指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode header = new ListNode(-1);
        header.next = head;

        ListNode slow = header;
        ListNode fast = header;

        while (n-- > 0) {
            fast = fast.next;
        }

        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next;

        slow.next = null;

        return header.next;
    }
}
