package com.leetcode.array;

/**
 * @ClassName LeetCode_35_搜索插入位置
 * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Author Administrator
 * @Date 2022-02-23 10:23
 * @Version 1.0.0
 */
public class LeetCode_35_搜索插入位置 {
    /**
     * 在数组中插入目标值，无非以下四种情况：
     * 1. 目标值在数组所有元素之前
     * 2. 目标值等于数组中某一元素
     * 3. 目标值插入数组中的位置
     * 4. 目标值在数组所有元素之后
     *
     * 左闭右闭
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

    /**
     * 左闭右开
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
