package com.leetcode.string;

/**
 * @ClassName LeetCode_剑指Offer_58II_左旋转字符串
 * @Description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @Author Administrator
 * @Date 2022-03-02 11:00
 * @Version 1.0.0
 */
public class LeetCode_剑指Offer_58II_左旋转字符串 {
    /**
     * 模拟
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 先把字符串整体旋转，再单独旋转前后两部分的字符串即可
     * abcdefg -> gfedc ba -> cdefg ab
     * 或者
     * abcdefg -> ba gfedc -> cdefg ab
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, len - 1);
        return sb.reverse().toString();
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
