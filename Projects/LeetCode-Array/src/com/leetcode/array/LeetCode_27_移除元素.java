package com.leetcode.array;

/**
 * @ClassName LeetCode_27_移除元素
 * @Description 给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用O(1)额外空间并原地修改输入数组。
 * 元素的顺序可以改变，你不需要考虑数组中超出新长度后面的元素。
 * @Author Administrator
 * @Date 2022-02-24 11:16
 * @Version 1.0.0
 */
public class LeetCode_27_移除元素 {
    /**
     * 暴力解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums.length;
        for (int i = 0; i < res; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                res--;
            }
        }
        return res;
    }

    /**
     * 双指针
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int slowIndex = 0;
        int fastIndex = 0;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        return slowIndex;
    }
}
