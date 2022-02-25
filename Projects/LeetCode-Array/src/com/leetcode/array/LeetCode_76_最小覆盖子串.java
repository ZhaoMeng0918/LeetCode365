package com.leetcode.array;

/**
 * @ClassName LeetCode_76_最小覆盖子串
 * @Description 给你一个字符串s，一个字符串t，返回s中涵盖t所有字符的最小子串。
 * 如果s中不存在涵盖t所有字符的子串，则返回空字符串""。
 * @Author Administrator
 * @Date 2022-02-25 10:35
 * @Version 1.0.0
 */
public class LeetCode_76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] have = new int[128];

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int min = s.length() + 1;
        int count = 0;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            if (need[r] == 0) {
                right++;
                continue;
            }

            if (have[r] < need[r]) {
                count++;
            }

            have[r]++;

            right++;

            while (count == t.length()) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }

                char l = s.charAt(left);

                if (need[l] == 0) {
                    left++;
                    continue;
                }

                if (have[l] == need[l]) {
                    count--;
                }

                have[l]--;

                left++;
            }
        }
        //如果最小长度还为初始值，说明没有符合条件的子串
        if (min == s.length() + 1) {
            return "";
        }
        //返回的为以记录的起始位置为起点，记录的最短长度为距离的指定字符串中截取的子串
        return s.substring(start, start + min);
    }
}
