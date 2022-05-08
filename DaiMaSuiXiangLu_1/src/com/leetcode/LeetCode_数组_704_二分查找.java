package com.leetcode;

public class LeetCode_数组_704_二分查找 {
    /**
     * 左闭右闭
     *
     * @param nums
     * @param target
     * @return
     */
    public int search_1(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        if (target < nums[0] || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    /**
     * 左闭右开
     *
     * @param nums
     * @param target
     * @return
     */
    public int search_2(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        if (target < nums[0] || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
