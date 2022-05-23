package com.leetcode;

public class LeetCode_哈希表_242_有效的字母异位词 {
    /**
     * 直接哈希解决
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        int sLen = s.toCharArray().length;
        for (int i = 0; i < sLen; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        int tLen = t.toCharArray().length;
        for (int i = 0; i < tLen; i++) {
            chars[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
