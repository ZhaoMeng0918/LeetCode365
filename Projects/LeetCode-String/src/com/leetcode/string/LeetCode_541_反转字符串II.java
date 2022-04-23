package com.leetcode.string;

import java.util.Arrays;

/**
 * @ClassName LeetCode_541_反转字符串II
 * @Description 给定一个字符串s和一个整数k，从字符串开头算起，每计数至2k个字符，就反转这2k字符中的前k个字符。
 * 如果剩余字符少于k个，则将剩余字符全部反转。
 * 如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样。
 * @Author Administrator
 * @Date 2022-03-02 9:51
 * @Version 1.0.0
 */
public class LeetCode_541_反转字符串II {
    /**
     * 模拟
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (; i + 2 * k < chars.length; i += 2 * k) {
            reverStrAssignScope(chars, i, i + k - 1);
        }

        // 如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样
        if (chars.length - i >= k) {
            reverStrAssignScope(chars, i, i + k - 1);
        }
        // 如果剩余字符少于k个，则将剩余字符全部反转
        else if (i - chars.length < k) {
            reverStrAssignScope(chars, i, chars.length - 1);
        }

        return new String(chars);
    }

    private void reverStrAssignScope(char[] chars, int leftIndex, int rightIndex) {
        while (leftIndex <= rightIndex) {
            char chr = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = chr;
            leftIndex++;
            rightIndex--;
        }
    }
}
