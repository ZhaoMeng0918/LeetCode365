package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_数组_844_比较含退格的字符串 {
    public boolean backspaceCompare_1(String s, String t) {
        return removeBackSpace_1(s).equals(removeBackSpace_1(t));
    }

    private String removeBackSpace_1(String str) {
        char[] chars = str.toCharArray();
        int slowIndex = chars.length - 1;
        int fastIndex = chars.length - 1;
        int backSpaceCount = 0;
        while (fastIndex >= 0) {
            if (chars[fastIndex] != '#') {
                if (backSpaceCount == 0) {
                    chars[slowIndex] = chars[fastIndex];
                    slowIndex--;
                } else {
                    backSpaceCount--;
                }
            } else {
                backSpaceCount++;
            }
            fastIndex--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = slowIndex + 1; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public boolean backspaceCompare_2(String s, String t) {
        return removeBackSpace_2(s).equals(removeBackSpace_2(t));
    }

    private String removeBackSpace_2(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                stack.addLast(str.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
