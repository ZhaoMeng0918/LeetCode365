package com.leetcode.linkedList;

/**
 * @ClassName LeetCode_面试题0207_链表相交
 * @Description 给你两个单链表的头节点，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回null。
 * @Author Administrator
 * @Date 2022-02-26 15:05
 * @Version 1.0.0
 */
public class LeetCode_面试题0207_链表相交 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null) lenA++;
        while (curB != null) lenB++;

        curA = headA;
        curB = headB;

        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        int gap = lenA - lenB;
        while (gap-- > 0) curA = curA.next;

        while (curA != null) {
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
