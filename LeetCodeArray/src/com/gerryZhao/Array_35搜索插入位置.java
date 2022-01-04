package com.gerryZhao;

/**
 * @ClassName Array_35搜索插入位置
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-03 14:32
 * @Version 1.0.0
 */
public class Array_35搜索插入位置 {
    /**
     * 题目一看有关键词：升序（有序），无重复元素 ----> 二分查找
     */
    // 版本一：左闭右闭
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else  return mid;
        }
        // 分别处理如下四种情况：
        // 目标值在数组所有元素之前[0, -1]
        // 目标值等于数组中某一个元素 return mid
        // 目标值插入数组中的位置 [left, right] return right + 1;
        // 目标值在数组所有元素之后[left, right]，return right + 1;
        return right + 1;
    }

    // 版本二：左闭右开
    public int searchInsert3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else  return mid;
        }
        // 分别处理如下四种情况：
        // 目标值在数组所有元素之前[0, 0)
        // 目标值等于数组中某一个元素 return mid
        // 目标值插入数组中的位置 [left, right) return right;
        // 目标值在数组所有元素之后[left, right)，return right;
        return right;
    }

    /**
     * 在数组中插入目标值，无非是这四种情况：
     * 目标值在数组所有元素之前
     * 目标值等于数组中某一个元素
     * 目标值插入数组中的位置
     * 目标值在数组所有元素之后
     */
    // 暴力解法
    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            // 处理前三种情况
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
}
