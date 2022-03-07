package com.leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode_6017_向数组中追加K个整数
 * @Description 给你一个整数数组nums和一个整数k。请你向nums中追加k个未出现在nums中的、互不相同的正整数，并使结果数组的元素和最小 。
 * 返回追加到nums中的k个整数之和。
 * @Author Administrator
 * @Date 2022-03-07 9:23
 * @Version 1.0.0
 */
public class LeetCode_6017_向数组中追加K个整数 {
    /**
     * 贪心+数学求和
     *
     * @param nums
     * @param k
     * @return
     */
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0, start = 1;
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (start < nums[i]) {
                int cnt = (int) (nums[i] - start) > k ? k : (int) (nums[i] - start);
                ans += (2L * start + cnt - 1) * cnt / 2;
                k -= cnt;
            }
            start = nums[i] + 1;
        }
        if (k > 0) {
            ans += (2L * start + k - 1) * k / 2;
        }
        return ans;
    }
}
