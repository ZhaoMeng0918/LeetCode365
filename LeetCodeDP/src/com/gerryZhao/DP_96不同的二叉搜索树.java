package com.gerryZhao;

/**
 * @ClassName DP_96不同的二叉搜索树
 * @Description 给定一个整数n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @Author Administrator
 * @Date 2021-11-30 14:32
 * @Version 1.0.0
 */
public class DP_96不同的二叉搜索树 {
    /**
     * 1. 确定dp数组以及下标的含义
     * dp[i]: 1 到 i 为节点组成的二叉搜索树的个数为dp[i]
     * 也可以理解是 i 的不同元素节点组成的二叉搜索树的个数为dp[i]，都是一样的。
     * 2. 确定递推关系式
     * dp[i] += dp[j-1]*dp[i-j];
     * 3. dp数组如何初始化
     * dp[0]=1;
     * 4. 确定遍历顺序
     * for (int i = 1; i <= n; i++) {
     *     for (int j = 1; j <= i; j++) {
     *         dp[i] += dp[j - 1] * dp[i - j];
     *     }
     * }
     * 5. 举例推导dp数组
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // dp[j - 1]: j-1 为 j 为头节点左子树节点数量
                // dp[i - j]: i-j 为 j 为头节点右子树节点数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
