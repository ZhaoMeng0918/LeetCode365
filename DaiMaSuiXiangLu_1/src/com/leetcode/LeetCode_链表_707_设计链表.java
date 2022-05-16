package com.leetcode;

public class LeetCode_链表_707_设计链表 {
}

class MyLinkedList {
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

    private int size;
    private ListNode header;

    public MyLinkedList() {
        size = 0;
        header = new ListNode();
    }

    public int get(int index) {
        if (index <= 0 || size < index) return -1;
        ListNode curNode = header.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, header.next);
        header.next = newNode;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val, null);
        ListNode curNode = header;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0 || size + 1 < index) {
            return;
        }
        ListNode curNode = header;
        for (int i = 0; i < index && curNode != null; i++) {
            curNode = curNode.next;
        }
        ListNode newNode = new ListNode(val, curNode.next);
        curNode.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index <= 0 || size < index) {
            return;
        }
        ListNode curNode = header;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
    }
}


