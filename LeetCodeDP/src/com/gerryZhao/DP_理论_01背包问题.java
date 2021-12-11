package com.gerryZhao;

/**
 * @ClassName DP_理论_01背包问题
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-01 10:43
 * @Version 1.0.0
 */
public class DP_理论_01背包问题 {
    /**
     * 对于面试的话，掌握【0-1背包】【完全背包】【多重背包】就够了
     * 最重要的就是：【0-1背包】
     * 有N件物品和一个最多能背重量为W的背包。
     * 第i件物品的重量是weight[i]，得到的价值是value[i]。
     * 每件物品仅能用一次，求解将哪些物品装入背包里物品价值总和最大。
     */
    /**
     * 举例：
     * 背包最大重量为: 4
     * 重量    价值
     * 物品0    1      15
     * 物品1    3      20
     * 物品2    4      30
     * <p>
     * 二维dp数组01背包
     * 1. 确定dp数组以及下标的含义
     * 对于背包问题，有一种写法，是使用二维数组，
     * dp[i][j]表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
     * 2. 确定递推公式
     * 两个方向推出dp[i][j]:
     * · 不放物品i: dp[i][j] = dp[i-1][j]
     * · 放物品i: dp[i][j] = dp[i-1][j-weight[i]] + value[i]
     * dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])
     * 3. dp数组如何初始化
     * 这一步挺复杂的，直接看教程。
     * 4. 确定遍历顺序
     * 5. 举例推导dp数组
     */

    /**
     * 背包问题模板
     *
     * @param weight 重量
     * @param value 价值
     * @param bagSize 背包容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length, value0 = 0;
        int[][] dp = new int[wLen + 1][bagSize + 1];
        for (int i = 0; i <= wLen; i++) {
            dp[i][0] = value0;
        }
        for (int i = 1; i <= wLen; i++) { // 先遍历物品
            for (int j = 1; j <= bagSize; j++) { // 再遍历背包
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        /**
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * ==>
         * 0 0 0 0 0
         * 0 15 15 15 15
         * 0 15 15 20 35
         * 0 15 15 20 35
         */
    }
}
