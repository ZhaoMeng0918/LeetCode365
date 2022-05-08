package com.leetcode;

public class LeetCode_数组_69_x的平方根 {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (x / mid >= mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
