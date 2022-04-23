package com.leetcode.stack_queue;

import java.util.Stack;

/**
 * @ClassName LeetCode_1047_删除字符串中所有相邻重复项
 * @Description 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在S上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串，答案保证唯一。
 * @Author Administrator
 * @Date 2022-03-03 11:36
 * @Version 1.0.0
 */
public class LeetCode_1047_删除字符串中所有相邻重复项 {
    /**
     * 栈
     *
     * @param s
     * @return
     */
    public String removeDuplicates1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public String removeDuplicates2(String s) {
        char[] chars = s.toCharArray();
        int fastIndex = 0;
        int slowInfex = 0;
        while (fastIndex < chars.length) {
            chars[slowInfex] = chars[fastIndex];
            if (slowInfex > 0 && chars[slowInfex] == chars[slowInfex - 1]) {
                slowInfex--;
            } else {
                slowInfex++;
            }
            fastIndex++;
        }
        return new String(chars, 0, slowInfex);
    }
}
