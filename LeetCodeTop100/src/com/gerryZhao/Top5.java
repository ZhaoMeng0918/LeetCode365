package com.gerryZhao;

/**
 * @ClassName Top5
 * @Description 最长回文子串
 * @Author Administrator
 * @Date 2021-11-28 14:49
 * @Version 1.0.0
 */
public class Top5 {
    public static void main(String[] args) {
        String t1 = "aabbaa";   // true
        String t2 = "aababaa";  // true
        String t3 = "aabbaabb"; // false
        String t4 = "aabbaab";  // false
        String t5 = "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";

        System.out.println(isPalindrome(t1));
        System.out.println(isPalindrome(t2));
        System.out.println(isPalindrome(t3));
        System.out.println(isPalindrome(t4));

        System.out.println(longestPalindrome1(t1));
        System.out.println(longestPalindrome1(t5));
    }

    /**
     * 暴力法
     * 超出时间限制
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int low = 0, high = 1;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j)) && j - i > high - low) {
                    low = i;
                    high = j;
                }
            }
        }
        return s.substring(low, high);
    }

    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len += 2;
                left--;
                right++;
            }
            if(len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    /**
     * 动态规划
     * 基于中心扩散改进
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;    //最长回文串的长度
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * 判断是否为回文串
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        for (int low = 0, high = str.length() - 1; low <= high; low++, high--) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
        }
        return true;
    }
}
