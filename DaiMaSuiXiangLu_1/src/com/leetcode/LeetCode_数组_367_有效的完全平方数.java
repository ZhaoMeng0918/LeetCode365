package com.leetcode;

public class LeetCode_数组_367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int tmp = num / mid;
            // 千万要注意，整型数据出现小数点会省略
            if (tmp == mid && num % tmp == 0) {
                return true;
            } else if (tmp >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
