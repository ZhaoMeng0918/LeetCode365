package com.leetcode.dp;

public class LeetCode_0_01背包理论基础 {
    public void _01BagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;
        int[][] dp = new int[wLen][bagSize + 1];
        // 初始化[i][0]
        for (int i = 0; i < wLen; i++) {
            dp[i][0] = 0;
        }
        // 初始化[0][j]
        for (int i = 0; i <= bagSize; i++) {
            if (i < weight[0]) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = weight[0];
            }
        }

        for (int i = 1; i < wLen; i++) { // 物品
            for (int j = 1; j <= bagSize; j++) { // 背包
                if (j < weight[i]) { // 放不下
                    dp[i][j] = dp[i - 1][j];
                } else { // 放得下
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
    }
}
