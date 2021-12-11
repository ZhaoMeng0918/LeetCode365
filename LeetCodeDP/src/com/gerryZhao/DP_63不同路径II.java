package com.gerryZhao;

/**
 * @ClassName DP_63不同路径II
 * @Description 相比较于62，增加了障碍物
 * @Author Administrator
 * @Date 2021-11-30 11:54
 * @Version 1.0.0
 */
public class DP_63不同路径II {
    /**
     * 重点: 有障碍的话，其标记对应的dp数组保持初始值为0即可
     * 1. 确定dp数组以及下标的含义
     * dp[i][j]: 表示从(0, 0)出发，到(i, j)有dp[i][j]条不同的路径
     * 2. 确定递推公式
     * if (obstacleGrid[i][j] == 0) { // 当(i, j)没有障碍的时候，再推导dp[i][j]
     *     dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     * }
     * 3. dp数组如何初始化
     * vector<vector<int>> dp(m, vector<int>(n, 0)); // 初始值为0
     * for (int i = 0; i < m; i++) dp[i][0] = 1;
     * for (int j = 0; j < n; j++) dp[0][j] = 1;
     * 4. 确定遍历顺序
     * 5. 举例推导dp数组
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            // 一旦遇到障碍，后续都到不了
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            // 一旦遇到障碍，后续都到不了
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
