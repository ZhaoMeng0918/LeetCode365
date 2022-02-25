package com.leetcode.array;

/**
 * @ClassName LeetCode_283_移动零
 * @Description 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意，必须在不复制数组的情况下对数组进行操作。
 * @Author Administrator
 * @Date 2022-02-24 15:25
 * @Version 1.0.0
 */
public class LeetCode_283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int slowIndex = 0;
        int fastIndex = 0;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        while (slowIndex < nums.length) {
            nums[slowIndex++] = 0;
        }
    }
}
