package com.gerryZhao;

/**
 * @ClassName Array_209长度最小的数组
 * @Description 给定一个含有n个正整数的数组和一个正整数s，找出该数组中满足其和>=s的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回0.
 * @Author Administrator
 * @Date 2022-01-05 11:07
 * @Version 1.0.0
 */
public class Array_209长度最小的数组_滑动窗口 {
    // 暴力解法
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;       // 子序列的数值之和
        int subLength = 0; // 子序列长度
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    res = res < subLength ? res : subLength;
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 滑动窗口
    // 双指针牛逼
    public static int minSubArrayLen2(int target, int[] nums) {
        int left = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
