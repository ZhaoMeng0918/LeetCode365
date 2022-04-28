package com.leetcode.dp;

public class LeetCode_322_零钱兑换 {
    public int coinChange(int[] coins, int amout) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amout + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amout; j++) {
                if (dp[j -coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amout] == max ? -1 : dp[amout];
    }
}
