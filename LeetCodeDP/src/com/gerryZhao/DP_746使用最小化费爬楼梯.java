package com.gerryZhao;

/**
 * @ClassName DP_746使用最小化费爬楼梯
 * @Description 数组的每个下标作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i]（从下标0开始）
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为0或者1的元素作为初始阶梯。
 * @Author Administrator
 * @Date 2021-11-29 16:44
 * @Version 1.0.0
 */
public class DP_746使用最小化费爬楼梯 {
    /**
     * 1. 确定dp数组以及下标的含义
     * dp[i]: 达到第i个台阶所花费的最少体力为dp[i]
     * 2. 确定递推公式
     * dp[i] = min(dp[i-1], dp[i-2]) + cost[i];
     * 3. dp数组如何初始化
     * dp[0] = cost[0]; dp[1] = cost[1];
     * 4. 确定遍历顺序
     * 从前向后
     * 备注: 稍微有点难度的动态规划，其遍历顺序并不容易确定下来。
     * 5. 举例推导dp数组
     * cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1];
     * dp: 1 100 2 3 3 103 4 5 104 6
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length -2]);
    }
}