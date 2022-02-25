package com.leetcode.array;

/**
 * @ClassName LeetCode_29_长度最小的子数组
 * @Description 给定一个含有n个正整数的数组和一个正整数s，找出该数组中满足其和>=s的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回0.
 * @Author Administrator
 * @Date 2022-02-25 9:19
 * @Version 1.0.0
 */
public class LeetCode_29_长度最小的子数组 {
    /**
     * 滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (;rightIndex < nums.length; rightIndex++) {
            sum += nums[rightIndex];
            while (sum >= target) {
                result = Math.min(result, rightIndex - leftIndex + 1);
                sum -= nums[leftIndex];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
