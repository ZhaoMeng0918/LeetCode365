package com.leetcode.dp;

public class LeetCode_518_零钱兑换II {
    public int change(int amout, int[] coins) {
        int[] dp = new int[amout + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amout; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amout];
    }
}
