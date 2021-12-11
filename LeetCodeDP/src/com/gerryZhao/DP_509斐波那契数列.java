package com.gerryZhao;

/**
 * @ClassName DP_509斐波那契数列
 * @Description TODO
 * @Author Administrator
 * @Date 2021-11-29 15:40
 * @Version 1.0.0
 */
public class DP_509斐波那契数列 {
    /**
     * 动态规划
     * 1. 确定dp数组以及下标的含义
     * dp[i]: 第i个数的斐波那契数值是dp[i]
     * 2. 确定递推公式
     * dp[i] = dp[i-1] + dp[i-2]
     * 3. dp数组如何初始化
     * dp[0] = 0; dp[1] = 1;
     * 4. 确定遍历顺序
     * 从递归公式dp[i] = dp[i-1] + dp[i-2]可以看出，dp[i]依赖于dp[i-1]和dp[i-2],
     * 那么遍历的顺序一定是从前到后遍历的。
     * 5. 举例推导dp数组
     * 假设N=10: dp数组为: 0 1 1 2 3 5 8 13 21 34 55
     */
    public static int fib(int n) {
        if (n < 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int fibRecursion(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibRecursion(n -1) + fibRecursion(n - 2);
    }
}
