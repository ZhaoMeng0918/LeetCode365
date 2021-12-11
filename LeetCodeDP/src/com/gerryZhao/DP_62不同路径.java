package com.gerryZhao;

import java.util.Arrays;

/**
 * @ClassName DP_62不同路径
 * @Description 一个机器人位于一个 m x n 的网格的左上角，机器人每次只能向下或者向右移动一步。
 * 试问，机器人试图达到网格的右下角，共有多少条不同的路径。
 * @Author Administrator
 * @Date 2021-11-30 11:04
 * @Version 1.0.0
 */
public class DP_62不同路径 {
    /**
     * 机器人走过的路径可以抽象为一棵二叉树，而叶子节点就是终点
     */
    public static int uniquePaths(int m, int n) {
        return dfs(1, 1, m, n);
    }

    public static int dfs(int i, int j, int m, int n) {
        if (i > m || j > n) { // 越界
            return 0;
        }
        if (i == m && j == n) {
            return 1;
        }
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    /**
     * 1. 确定dp数组以及下标的含义
     * dp[i][j]: 表示从(0, 0)出发，到(i, j)有dp[i][j]条不同的路径
     * 2. 确定递推公式
     * dp[i][j] = dp[i-1][j] + dp[j][j-1]
     * 3. dp数组的初始化
     * 重要!!!: 首先dp[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理
     * for (int i = 0; i < m; i++) dp[i][0] = 1;
     * for (int j = 0; j < n; j++) dp[0][j] = 1;
     * 4. 确定遍历顺序
     * 从前往后
     * 5. 举例推导dp数组
     * 略
     */
    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 数论方法
     * 一共走m, n的话，无论怎么走，走到终点都需要m + n - 2步
     * 在这m + n - 2步中，一定有m - 1步是要向下走的。
     * 那么有几种走法呢？
     * 可以转化为，给你m + n - 2个不同的数，随便取m - 1个数，有几种取法。
     * 那么这就是一个组合问题了。
     */
    public static int uniquePaths2(int m, int n) {
        long numerator = 1; // 分子
        int denomonator = m - 1; // 分母
        int count = m - 1;
        int t = m + n - 2;
        while (count-- != 0) {
            numerator *= (t--);
            while (denomonator != 0 && numerator % denomonator == 0) {
                numerator /= denomonator;
                denomonator--;
            }
        }
        return (int) numerator;
    }

    // 比较容易看懂的写法
    public static int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int i = n, j = 1; j < m; i++, j++) {
            ans = ans * i / j;
        }
        return (int)ans;
    }
}
