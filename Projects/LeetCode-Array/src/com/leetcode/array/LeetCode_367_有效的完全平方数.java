package com.leetcode.array;

/**
 * @ClassName LeetCode_367_有效的完全平方数
 * @Description 给定一个正整数num ，编写一个函数，如果num是一个完全平方数，则返回true，否则返回false 。
 * @Author Administrator
 * @Date 2022-02-23 10:25
 * @Version 1.0.0
 */
public class LeetCode_367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid * mid < num) left = mid + 1;
            else if (mid * mid > num) right = mid - 1;
            else return true;
        }
        return false;
    }
}
