package com.gerryZhao;

/**
 * @ClassName DP_70爬楼梯
 * @Description TODO
 * @Author Administrator
 * @Date 2021-11-29 15:55
 * @Version 1.0.0
 */
public class DP_70爬楼梯 {
    /**
     * 思路: 爬到第一层楼有一种办法，爬到第二层楼梯有两种办法
     * 那么第一层楼梯再跨两步就到第三层，第二层楼梯再跨一步就到第三层。
     * 所以，到第三层楼梯的状态，可以由到第二层楼梯和到第一层楼梯的状态推导出来。
     * 即: 动态规划
     * 1. 确定dp数组以及下标的含义
     * dp[i]: 爬到第i层楼梯，有dp[i]种方法
     * 2. 确定递推公式
     * dp[i] = d[i-1] + dp[i-2]
     * 3. dp数组如何初始化
     * dp[1] = 2; dp[2] = 2;
     * 4. 确定遍历顺序
     * 从递推公式dp[i] = d[i-1] + dp[i-2]种可以看出，遍历顺序一定是从前向后遍历的
     * 5. 举例推导dp数组
     * 假设N=5: dp数组为: 1 2 3 5 8
     */
    // 这道题语DP_509斐波那契数列相比难在: 斐波那契数列已经将动态规划种递推公式和初始化都给出来了。
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化空间复杂度
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }

    /**
     * 继续深化: 一步一个台阶，两个台阶，...，直到m个台阶，有多少种方法爬到n阶楼顶
     * 【完全背包问题】
     * 1. 确定dp数组以及下标的含义
     * dp[i]: 爬到第i层楼梯，有dp[i]种方法
     * 2. 确定递推公式
     * dp[i] = d[i-1] + dp[i-2] + ... + dp[1]
     * 3. dp数组如何初始化
     * dp[1] = 2; dp[2] = 2;
     * 4. 确定遍历顺序
     * 从递推公式dp[i] = d[i-1] + dp[i-2]种可以看出，遍历顺序一定是从前向后遍历的
     * 5. 举例推导dp数组
     * 假设N=5: dp数组为: 1 2 3 5 8
     * @param n
     * @return
     */
    public static int climbStairs3(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
