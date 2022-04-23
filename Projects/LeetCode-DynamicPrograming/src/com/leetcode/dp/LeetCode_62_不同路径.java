package com.leetcode.dp;

public class LeetCode_62_不同路径 {
    /**
     * 动规五部曲：
     * 1. 确定dp数组以及下标的含义：dp[i][j]定义是：到达第i行j列有多少种路径
     * 2. 确定递推公式：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3. dp数组如何初始化：dp[i][0] = 1; dp[0][j] = 1;
     * 4. 确定遍历顺序：从递推公式可知，遍历顺序一定是从前到后遍历的
     * 5. 举例推导dp数组
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
