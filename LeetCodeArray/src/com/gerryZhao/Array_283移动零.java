package com.gerryZhao;

/**
 * @ClassName Array_283移动零
 * @Description 给定一个数组nums，编写一个函数将所有0移动到数组得末尾，同时保持非零元素得相对顺序。
 * @Author Administrator
 * @Date 2022-01-04 14:24
 * @Version 1.0.0
 */
public class Array_283移动零 {
    // 先来一手暴力解法
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[length - 1] = 0;
                i--;
                length--;
            }
        }
    }

    // 双指针
    // 思路就是：先把数据往前移动，最后根据slowIndex位置，再在后面补齐0
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int slowIndex = 0, fastIndex = 0;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != 0){
                nums[slowIndex++] = nums[fastIndex];
            }
            fastIndex++;
        }
        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
