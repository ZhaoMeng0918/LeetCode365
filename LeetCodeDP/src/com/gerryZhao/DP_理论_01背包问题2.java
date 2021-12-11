package com.gerryZhao;

/**
 * @ClassName DP_理论_01背包问题2
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-01 11:30
 * @Version 1.0.0
 */
public class DP_理论_01背包问题2 {
    /**
     * 一维dp数组（滚动数组）
     * 把二维dp降为一维dp
     *
     * 使用二维数组的时候，递推公式: dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i])
     * 其实可以发现如果把dp[i-1]那层拷贝到dp[i]上，表达式完全可以是: dp[i][j] = max(dp[i][j], dp[i][j-weight[i]]+value[i])
     * 这就是滚动数组得由来，需要满足得条件是上一层可以重复利用，直接拷贝到当前层。
     *
     * 1. 确定dp数组得定义
     * 在一维数组中，dp[j]表示，容量为j得背包，所背得物品价值可以最大为dp[j]。
     * 2. 一维dp数组得递推方式
     * dp[j] = max(dp[j], dp[j-weight[i]] + value[i])
     * 3. 一维dp数组如何初始化
     * 关于初始化，一定要和dp数组的定义吻合，否则到递推公式的时候就会越来越乱
     *
     *
     * @param weight
     * @param value
     * @param bagWeight
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int wLen = weight.length;
        // dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        // 先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp[j] + " ");
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }
}
