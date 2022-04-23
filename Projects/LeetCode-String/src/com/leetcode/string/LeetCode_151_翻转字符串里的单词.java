package com.leetcode.string;

/**
 * @ClassName LeetCode_151_翻转字符串里的单词
 * @Description 给你一个字符串s，逐个翻转字符串中的所有单词。
 * 单词是由非空格字符组成的字符串，s中使用至少一个空格将字符串中的单词分隔开。
 * 请你返回一个翻转s中单词顺序并用单个空格相连的字符串。
 * 说明：
 * 输入字符串s可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * @Author Administrator
 * @Date 2022-03-02 10:31
 * @Version 1.0.0
 */
public class LeetCode_151_翻转字符串里的单词 {
    /**
     * 将整个字符串都翻转过来，再把每个单词反转一下。
     * 具体步骤：
     * 1. 移除多余空格
     * 2. 将整个字符串反转
     * 3. 将每个单词反转
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
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

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
