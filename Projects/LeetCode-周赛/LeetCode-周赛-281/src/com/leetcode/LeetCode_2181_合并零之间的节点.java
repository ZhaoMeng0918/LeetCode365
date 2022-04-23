package com.leetcode;

import java.util.List;

/**
 * @ClassName LeetCode_2181_合并零之间的节点
 * @Description 给你一个链表的头节点head，该链表包含由0分隔开的一连串整数。
 * 链表的开端和末尾的节点都满足Node.val == 0 。
 * 对于每两个相邻的0，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有0移除，修改后的链表不应该含有任何0。
 * <p>
 *  返回修改后链表的头节点 head 。
 * @Author Administrator
 * @Date 2022-03-05 10:12
 * @Version 1.0.0
 */
public class LeetCode_2181_合并零之间的节点 {
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

    public ListNode mergeNodes1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.next.val != 0) {
                curNode.val += curNode.next.val;
                curNode.next = curNode.next.next;
            } else {
                if (curNode.next.next == null) {
                    curNode.next = null;
                } else {
                    curNode = curNode.next;
                }
            }
        }
        return head;
    }

    public ListNode mergeNodes2(ListNode head) {
        ListNode slow = head, fast = slow.next;
        int sum = 0;
        while (fast != null) {
            if (sum == 0) {
                slow = slow.next;
            }
            if (fast.val == 0) {
                slow.val = sum;
                sum = 0;
            } else {
                sum += fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head.next;
    }
}
