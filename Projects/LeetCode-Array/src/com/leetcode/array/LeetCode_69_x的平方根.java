package com.leetcode.array;

/**
 * @ClassName LeetCode_69_x的平方根
 * @Description 给你一个非负整数x，计算并返回x的算术平方根。由于返回类型是整数，结果只保留整数部分，小数部分将被舍去 。
 * @Author Administrator
 * @Date 2022-02-23 10:24
 * @Version 1.0.0
 */
public class LeetCode_69_x的平方根 {
    public int mySqrt(int x) {
        if (x == 1)  return 1;
        int left = 0;
        int right = x;
        while (right - left > 1) {
            int mid = left + ((right - left) >> 1);
            if (x / mid < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
