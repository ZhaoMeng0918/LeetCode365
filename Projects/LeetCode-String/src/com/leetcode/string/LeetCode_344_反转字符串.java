package com.leetcode.string;

/**
 * @ClassName LeetCode_344_反转字符串
 * @Description 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组s的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * @Author Administrator
 * @Date 2022-03-02 9:46
 * @Version 1.0.0
 */
public class LeetCode_344_反转字符串 {
    /**
     * 双指针
     *
     * @param s
     */
    public void reverseString1(char[] s) {
        if (s == null || s.length <= 1) return;
        int leftIndex = 0;
        int rightIndex = s.length - 1;
        while (leftIndex <= rightIndex) {
            char chr = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = chr;
            leftIndex++;
            rightIndex--;
        }
        return;
    }
}
