package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_数组_76_最小覆盖子串 {
    /**
     * 滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        // need[i]表示需要该元素的数量, 0代表不需要, <0代表多余的数量
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int minSize = Integer.MAX_VALUE;
        int needCnt = t.length();
        int start = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (need[rightChar] > 0) {
                needCnt--;
            }
            need[rightChar]--;

            if (needCnt == 0) {
                char leftChar = s.charAt(left);
                while (need[leftChar] < 0) {
                    need[leftChar]++;
                    left++;
                    leftChar = s.charAt(left);
                }
                if (right - left + 1 < minSize) {
                    minSize = right - left + 1;
                    start = left;
                }

                need[s.charAt(left)]++;
                left++;
                needCnt++;
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);
    }
}
