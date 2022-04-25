package com.leetcode.dp;

import javax.swing.plaf.IconUIResource;

public class LeetCode_1049_最后一块石头的重量II {
    public int lastStoneWeight(int[] stones) {
        // 将石头质量均分，利用01背包思路去找最大的存放质量
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int tmp = sum;
        sum /= 2;
        int[] dp = new int[sum + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return tmp - 2 * dp[sum];
    }

}
