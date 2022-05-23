package com.leetcode;

public class LeetCode_哈希表_383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        int sLen = ransomNote.toCharArray().length;
        for (int i = 0; i < sLen; i++) {
            chars[ransomNote.charAt(i) - 'a']++;
        }
        int tLen = magazine.toCharArray().length;
        for (int i = 0; i < tLen; i++) {
            chars[magazine.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
