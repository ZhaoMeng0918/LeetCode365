package com.leetcode.hashTable;

import java.util.Arrays;

/**
 * @ClassName LeetCode_242_有效的字母异位词
 * @Description 给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词。
 * 你可以假设字符串只包含小写字母。
 * @Author Administrator
 * @Date 2022-02-28 9:34
 * @Version 1.0.0
 */
public class LeetCode_242_有效的字母异位词 {
    /**
     * 哈希表
     * 与周赛282第2题同
     *
     * 用时：3ms
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for (int num: arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 理论相同，用时1ms
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        int[] record = new int[26];
        /**
         * s.toCharArray()相对于循环s.charAt()性能要更好一些
         */
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
