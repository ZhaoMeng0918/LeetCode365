package com.gerryZhao;

/**
 * @ClassName Array_69x的平方根
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-03 20:06
 * @Version 1.0.0
 */
public class Array_69x的平方根 {
    public int mySqrt(int x) {
        int left = 0, right = x / 2 + 1, res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if ((long) mid * mid <= x) {
                res = mid; // 寻找左区间
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
