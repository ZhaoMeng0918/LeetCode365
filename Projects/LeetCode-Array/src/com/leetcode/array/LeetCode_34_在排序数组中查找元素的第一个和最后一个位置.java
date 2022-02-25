package com.leetcode.array;

/**
 * @ClassName LeetCode_34_在排序数组中查找元素的第一个和最后一个位置
 * @Description 给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。
 * @Author Administrator
 * @Date 2022-02-23 10:24
 * @Version 1.0.0
 */
public class LeetCode_34_在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 采用二分法分别寻找左边界和右边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        // 情况三
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        // 情况二
        return new int[]{-1, -1};
    }

    private int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) {
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    private int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
}
