package com.leetcode.dp;

public class LeetCode_509_斐波那契数列 {
    /**
     * 动规五部曲：
     * 1. 确定dp数组以及下标的含义：dp[i]定义是：第i个数的斐波那契数值是dp[i]
     * 2. 确定递推公式：dp[i] = dp[i-1] + dp[i-2]
     * 3. dp数组如何初始化：dp[0] = 0; dp[1] = 1;
     * 4. 确定遍历顺序：从递推公式可知，遍历顺序一定是从前到后遍历的
     * 5. 举例推导dp数组
     */
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
