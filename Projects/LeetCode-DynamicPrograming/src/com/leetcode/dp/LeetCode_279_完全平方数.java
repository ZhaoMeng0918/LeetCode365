package com.leetcode.dp;

public class LeetCode_279_完全平方数 {
    public int numSquares(int n){
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
