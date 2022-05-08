package com.leetcode;

public class LeetCode_数组_283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
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
