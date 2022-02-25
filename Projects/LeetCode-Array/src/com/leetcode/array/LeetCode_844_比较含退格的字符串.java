package com.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName LeetCode_844_比较含退格的字符串
 * @Description 给定s和t两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回true。#代表退格字符。
 * 注意，如果对空白文本输入退格字符，文本继续为空。
 * @Author Administrator
 * @Date 2022-02-24 15:26
 * @Version 1.0.0
 */
public class LeetCode_844_比较含退格的字符串 {
    /**
     * 采用双端队列
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare1(String s, String t) {
        if ((s ==null && t != null) || (s !=null && t == null)) return  false;
        return this.formatStr(s).equals(this.formatStr(t));
    }

    private String formatStr(String str) {
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

    /**
     *
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare2(String s, String t){
        int sSkipNum = 0;
        int tSkipNum = 0;
        int i = s.length() - 1;
        int j = s.length() - 1;
        while (true) {
            while (i >= 0) {
                if (s.charAt(i) == '#') sSkipNum++;
                else {
                    if (sSkipNum > 0) sSkipNum--;
                    else break;
                }
                i--;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') tSkipNum++;
                else {
                    if (tSkipNum > 0) tSkipNum--;
                    else break;
                }
                j--;
            }
            if (i < 0 || j < 0) {
                break;
            }
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        if (i == -1 && j == -1) {
            return true;
        }
        return false;
    }
}
