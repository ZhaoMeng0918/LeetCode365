package com.gerryZhao;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_切割问题_131分割回文串_Hard
 * @Description 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 * 返回s所有可能的分割方案。
 * @Author Administrator
 * @Date 2021-12-07 14:22
 * @Version 1.0.0
 */
public class Backtracking_切割问题_131分割回文串_Hard {
    /**
     * 本题涉及到两个关键问题：
     * 1. 切割问题，有不同的切割方式
     * 2. 判断回文
     */
    List<List<String>> lists = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    private void backTracking(String s, int startIndex) {
        // 如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 如果[startIndex, i]是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.addLast(str);
            } else {
                continue;
            }
            // 起始位置后移，保证不重复
            backTracking(s, i + 1);
            path.removeLast();
        }
    }

    /**
     * 判断是否是回文串
     *
     * @param s
     * @param startIndex
     * @param end
     * @return
     */
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}
