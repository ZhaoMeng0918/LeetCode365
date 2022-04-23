package com.leetcode.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LeetCode_225_用队列实现栈
 * @Description 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、pop、peek、empty）
 * @Author Administrator
 * @Date 2022-03-03 11:35
 * @Version 1.0.0
 */
public class LeetCode_225_用队列实现栈 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }
}

class MyStack {

    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    private int curUse = 1;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        switch (curUse) {
            case 1:
                queue1.offer(x);
                break;
            case 2:
                queue2.offer(x);
                break;
        }
    }

    public int pop() {
        transform();
        return curUse == 2 ? queue1.poll() : queue2.poll();
    }

    public int top() {
        transform();
        int res = curUse == 2 ? queue1.poll() : queue2.poll();
        switch (curUse) {
            case 2:
                queue2.offer(res);
                break;
            case 1:
                queue1.offer(res);
                break;
        }
        return res;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    private void transform() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return;
        }
        int count = 0;
        switch (curUse) {
            case 1:
                count = queue1.size() - 1;
                while (count-- > 0) {
                    queue2.offer(queue1.poll());
                }
                curUse = 2;
                break;
            case 2:
                count = queue2.size() - 1;
                while (count-- > 0) {
                    queue1.offer(queue2.poll());
                }
                curUse = 1;
                break;
        }
    }
}
