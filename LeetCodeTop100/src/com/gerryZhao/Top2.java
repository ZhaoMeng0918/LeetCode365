package com.gerryZhao;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @ClassName Top2
 * @Description 两数相加
 * @Author Administrator
 * @Date 2021-11-23 11:44
 * @Version 1.0.0
 */
public class Top2 {

    public static void main(String[] args) {
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

    /**
     * 思路: 模拟
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int count = l1.val + l2.val;
        ListNode res = new ListNode(count % 10);
        boolean flag = count >= 10;
        int carry = flag ? 1: 0;

        ListNode tmp = res;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            count = l1.val + l2.val + carry;
            tmp.next = new ListNode(count % 10);
            tmp = tmp.next;
            flag = count >= 10;
            carry = flag ? 1: 0;
        }

        while (l1.next != null) {
            l1 = l1.next;
            count = l1.val + carry;
            tmp.next = new ListNode(count % 10);
            tmp = tmp.next;
            flag = count >= 10;
            carry = flag ? 1 : 0;
        }

        while (l2.next != null) {
            l2 = l2.next;
            count = l2.val + carry;
            tmp.next = new ListNode(count % 10);
            tmp = tmp.next;
            flag = count >= 10;
            carry = flag ? 1 : 0;
        }

        if(flag) {
            tmp.next = new ListNode(1);
        }

        return res;
    }
}
