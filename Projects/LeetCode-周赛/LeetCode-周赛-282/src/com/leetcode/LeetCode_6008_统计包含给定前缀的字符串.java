package com.leetcode;

/**
 * @ClassName LeetCode_6008_统计包含给定前缀的字符串
 * @Description 给你一个字符串数组words和一个字符串pref。返回words中以pref作为前缀的字符串的数目。
 * 字符串s的前缀就是s的任一前导连续字符串。
 * 链接：https://leetcode-cn.com/problems/counting-words-with-a-given-prefix/
 * @Author Administrator
 * @Date 2022-02-27 10:42
 * @Version 1.0.0
 */
public class LeetCode_6008_统计包含给定前缀的字符串 {
    /**
     * 常规解法
     *
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        if (words == null || words.length == 0) return 0;
        if (pref == null || pref.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (isPrefix(words[i], pref)) {
                res++;
            }
        }
        return res;
    }

    /**
     * 判断str2是否是str1的前缀
     *
     * @param str1
     * @param str2
     * @return
     */
    private boolean isPrefix(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != str1.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 直接遍历+API
     *
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount2(String[] words, String pref) {
        int cnt = 0;
        for (String s : words) {
            if (s.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}
