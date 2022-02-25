package com.leetcode.array;

/**
 * @ClassName LeetCode_977_有序数组的平方
 * @Description 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * @Author Administrator
 * @Date 2022-02-24 15:26
 * @Version 1.0.0
 */
public class LeetCode_977_有序数组的平方 {
    /**
     * 左右指针
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            if (Math.abs(nums[leftIndex]) <= Math.abs(nums[rightIndex])) {
                res[index--] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            } else {
                res[index--] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            }
        }
        return res;
    }
}
