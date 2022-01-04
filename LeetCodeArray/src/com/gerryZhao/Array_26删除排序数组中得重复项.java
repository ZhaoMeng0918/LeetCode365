package com.gerryZhao;

/**
 * @ClassName Array_26删除排序数组中得重复项
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-04 11:45
 * @Version 1.0.0
 */
public class Array_26删除排序数组中得重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int slowIndex = 1, fastIndex = 1;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != nums[fastIndex-1]) {
                nums[slowIndex++] = nums[fastIndex];
            }
            fastIndex++;
        }
        return slowIndex;
    }

}
