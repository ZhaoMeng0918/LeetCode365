package com.leetcode.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode_15_三数之和
 * @Description 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a, b, c，使得a+b+c=0。
 * 请你找出所有和为0且不重复的三元组。
 * @Author Administrator
 * @Date 2022-03-01 10:21
 * @Version 1.0.0
 */
public class LeetCode_15_三数之和 {
    /**
     * 排序+双指针
     * <p>
     * 模式识别：利用排序避免重复答案
     *
     * 1 + 2数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) right--;
                else if (sum < 0) left++;
                else  {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
