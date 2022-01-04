package com.gerryZhao;

/**
 * @ClassName Array_367有效的完全平方数
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-03 20:18
 * @Version 1.0.0
 */
public class Array_367有效的完全平方数 {
    // 二分查找
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long square = (long) mid * mid;
            if (square < num) left = mid + 1;
            else if (square > num) right = mid - 1;
            else return true;
        }
        return false;
    }
}
