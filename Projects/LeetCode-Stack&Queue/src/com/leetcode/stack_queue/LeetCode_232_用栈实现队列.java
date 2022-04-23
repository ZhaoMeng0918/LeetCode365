package com.leetcode.stack_queue;

import java.util.Stack;

/**
 * @ClassName LeetCode_232_用栈实现队列
 * @Description 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的所有操作（push、pop、peek、empty）
 * @Author Administrator
 * @Date 2022-03-03 11:35
 * @Version 1.0.0
 */
public class LeetCode_232_用栈实现队列 {
    class MyQueue {

        // 队列入口
        private Stack<Integer> stack1;

        // 队列出口
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            stack1ToStack2();
            return stack2.pop();
        }

        public int peek() {
            stack1ToStack2();
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        private void stack1ToStack2() {
            if (!stack2.isEmpty()) return;
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
