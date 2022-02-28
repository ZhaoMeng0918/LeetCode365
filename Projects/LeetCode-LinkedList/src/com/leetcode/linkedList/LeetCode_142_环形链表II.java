package com.leetcode.linkedList;

/**
 * @ClassName LeetCode_142_环形链表II
 * @Description 给定一个链表的头节点head，返回链表入环的第一个节点。如果链表无环，则返回null。
 * @Author Administrator
 * @Date 2022-02-26 15:06
 * @Version 1.0.0
 */
public class LeetCode_142_环形链表II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 判断链表是否有环；
     * 如果有环，如何找到这个环的入口；
     *
     * 判断链表有环：可以使用快慢指针，分别定义fast和slow指针，从头结点出发，
     * fast指针每次移动两个节点，slow指针每次移动一个节点，如果fast和slow指针在途中相遇，说明这个链表有环。
     * 为什么一定会相遇？因为fast每次比slow多走一个节点，也就是说，fast是一个节点一个节点靠近slow的。
     *
     * 如果有环，如何找到这个环的入口：
     *
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
