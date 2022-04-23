package com.leetcode;

/**
 * @ClassName LeetCode_2180_统计各位数字之和为偶数的整数个数
 * @Description 给你一个正整数num，请你统计并返回小于等于num且各位数字之和为偶数的正整数的数目。
 * 正整数的各位数字之和是其所有位上的对应数字相加的结果。
 * @Author Administrator
 * @Date 2022-03-05 10:04
 * @Version 1.0.0
 */
public class LeetCode_2180_统计各位数字之和为偶数的整数个数 {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int curNum = i;
            int tmp = 0;
            while (curNum > 0) {
                tmp += curNum % 10;
                curNum /= 10;
            }
            if (tmp % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_2180_统计各位数字之和为偶数的整数个数 lc = new LeetCode_2180_统计各位数字之和为偶数的整数个数();
        lc.countEven(30);
    }
}
