package com.gerryZhao;

/**
 * @ClassName Array_34在排序数组中查找元素的第一个和最后一个位置
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-03 15:02
 * @Version 1.0.0
 */
public class Array_34在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 关键词：升序（有序），但是有重复的元素
     */

    // 暴力解法
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || nums[nums.length - 1] < target)
            return new int[]{-1, -1};
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && left == -1) {
                left = i;
                right = i;
                for (int j = left + 1; j < nums.length; j++) {
                    if (nums[j] != target) {
                        break;
                    }
                    right = j;
                }
            }
        }
        return new int[]{left, right};
    }

    // 二分查找
    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || nums[nums.length - 1] < target)
            return new int[]{-1, -1};
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        return new int[]{-1, -1};
    }

    // 寻找右区间
    private int getRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    // 寻找左区间
    private int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if (nums[mid] >= target) {
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }

    // 解法3
    // 首先，在nums数组中二分查找 target
    // 如果二分查找失败，则直接返回 -1， -1
    // 如果查找成功，左右滑动指针
    public int[] searchRange3(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return new int[]{-1, -1};
        int left = index;
        int right = index;
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) left--;
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) right++;
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
