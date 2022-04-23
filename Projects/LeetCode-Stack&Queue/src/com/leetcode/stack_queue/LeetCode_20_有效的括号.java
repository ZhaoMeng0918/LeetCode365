package com.leetcode.stack_queue;

import java.util.Stack;

/**
 * @ClassName LeetCode_20_有效的括号
 * @Description 给定一个只包括( ) { } [ ]的字符串，判断
 * @Author Administrator
 * @Date 2022-03-03 11:36
 * @Version 1.0.0
 */
public class LeetCode_20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char chr : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(chr);
                continue;
            }
            switch (chr) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(chr);
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(chr);
                    }
                    break;
                case ']':

                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(chr);
                    }
                    break;
                default:
                    stack.push(chr);
            }
        }
        return stack.isEmpty();
    }
}
