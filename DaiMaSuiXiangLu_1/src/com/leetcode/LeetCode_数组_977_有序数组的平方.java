package com.leetcode;

public class LeetCode_数组_977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
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
