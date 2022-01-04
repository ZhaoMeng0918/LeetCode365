package com.gerryZhao;

import java.util.Arrays;

/**
 * @ClassName Array_977有序数组得平方
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-04 16:03
 * @Version 1.0.0
 */
public class Array_977有序数组得平方 {
    // 暴力解法
    // 每个数平方，排个序
    public int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 双指针
    // 这里新增了一个数组，就很烦
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int leftIndex = 0, rightIndex = nums.length - 1;
        int[] res = new int[nums.length];
        int length = nums.length - 1;
        while (leftIndex <= rightIndex) {
            if (Math.abs(nums[leftIndex]) >= Math.abs(nums[rightIndex])) {
                res[length--] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            } else {
                res[length--] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }
        }
        return res;
    }
}
