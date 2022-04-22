package com.leetcode.dp;

public class LeetCode_746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        // 注意：最后一步可以理解为不用花费，所以取倒数第一步，第二步的最小值
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
