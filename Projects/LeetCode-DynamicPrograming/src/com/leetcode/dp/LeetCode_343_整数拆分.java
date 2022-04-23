package com.leetcode.dp;

public class LeetCode_343_整数拆分 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // j * (i - j) 指将 i 拆分成两个整数
                // j * dp[i - j]) 指将 i 拆分成两个及两个以上的个数
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
