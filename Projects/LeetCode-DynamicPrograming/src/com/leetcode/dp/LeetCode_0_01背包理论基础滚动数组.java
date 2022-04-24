package com.leetcode.dp;

public class LeetCode_0_01背包理论基础滚动数组 {
    public void _01BagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;
        int[] dp = new int[bagSize+1];
        for (int i = 0; i < wLen; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }
    }
}
