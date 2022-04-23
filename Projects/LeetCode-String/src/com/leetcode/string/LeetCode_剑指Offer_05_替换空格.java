package com.leetcode.string;

/**
 * @ClassName LeetCode_剑指Offer_05_替换空格
 * @Description 请实现一个函数，把字符串s中的每个空格替换成"%20"
 * @Author Administrator
 * @Date 2022-03-02 10:15
 * @Version 1.0.0
 */
public class LeetCode_剑指Offer_05_替换空格 {
    /**
     * 从后往前搞
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        char[] chars = new char[s.length() + 2 * count];
        int index = chars.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                chars[index--] = s.charAt(i);
            } else {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            }
        }
        return new String(chars);
    }
}
