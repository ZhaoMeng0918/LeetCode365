package com.leetcode.linkedList;

/**
 * @ClassName LeetCode_206_反转链表
 * @Description 给你单链表的头结点head，请你反转链表，并返回反转后的链表。
 * @Author Administrator
 * @Date 2022-02-26 15:04
 * @Version 1.0.0
 */
public class LeetCode_206_反转链表_难 {
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
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode header = head;
        ListNode tmp = head;
        while (tmp.next != null) {
            ListNode cur = tmp.next;
            tmp.next = cur.next;
            cur.next = header;
            header = cur;
        }
        return header;
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
