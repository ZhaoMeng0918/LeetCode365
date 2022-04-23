package com.leetcode;

/**
 * @ClassName LeetCode_2182_构造限制重复的字符串
 * @Description 给你一个字符串s和一个整数repeatLimit，用s中的字符构造一个新字符串repeatLimitedString，
 * 使任何字母连续出现的次数都不超过repeatLimit次。你不必使用s中的全部字符。
 * 返回字典序最大的repeatLimitedString。
 * @Author Administrator
 * @Date 2022-03-05 10:49
 * @Version 1.0.0
 */
public class LeetCode_2182_构造限制重复的字符串 {
    /**
     * 模拟
     *
     *
     * @param s
     * @param repeatLimit
     * @return
     */
    public String repeatLimitedString1(String s, int repeatLimit) {
        int[] chars = new int[26];
        for (char chr : s.toCharArray()) {
            chars[chr - 'a']++;
        }

        int slowIndex = chars.length - 1;
        int fastIndex = chars.length - 1;

        StringBuilder res = new StringBuilder();

        while (fastIndex >= 0) {
            while (fastIndex >= 0 && chars[fastIndex] == 0) {
                fastIndex--;
            }
            if (fastIndex < 0) {
                return res.toString();
            }

            while (slowIndex >= 0 && chars[slowIndex] == 0) {
                slowIndex--;
            }
            if (slowIndex < 0) {
                return res.toString();
            }

            if (slowIndex != fastIndex) {
                char chr = (char) (fastIndex + 'a');
                res.append(chr);
                chars[fastIndex]--;
                fastIndex = slowIndex;
            } else {
                int count = 1;
                while (chars[slowIndex] > 0 && count <= repeatLimit) {
                    char chr = (char) (fastIndex + 'a');
                    res.append(chr);
                    chars[slowIndex]--;
                    count++;
                }
                if (chars[slowIndex] == 0) {
                    slowIndex--;
                }
                fastIndex--;
            }
        }
        return res.toString();
    }
}
