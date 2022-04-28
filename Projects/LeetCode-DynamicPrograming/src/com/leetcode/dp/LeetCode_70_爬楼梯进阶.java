package com.leetcode.dp;

public class LeetCode_70_爬楼梯进阶 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] weight = {1, 2};
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (i > weight[j]) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
