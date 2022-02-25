package com.leetcode.array;

/**
 * @ClassName LeetCode_26_删除排序数组中的重复项
 * @Description 给你一个升序排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 元素的相对顺序应该保持一致。由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。
 * 更规范地说，如果在删除重复项之后有k个元素，那么nums的前k个元素应该保存最终结果。
 * 将最终结果插入nums的前k个位置后返回k。
 * 不要使用额外的空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @Author Administrator
 * @Date 2022-02-24 15:25
 * @Version 1.0.0
 */
public class LeetCode_26_删除排序数组中的重复项 {
    /**
     * 快慢指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int slowIndex = 0;
        int fastIndex = 1;
        while (fastIndex < nums.length) {
            if (nums[slowIndex] != nums[fastIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[fastIndex];
            }
            fastIndex++;
        }
        return slowIndex + 1;
    }
}
