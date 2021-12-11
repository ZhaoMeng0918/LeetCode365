package com.gerryZhao;

/**
 * @ClassName DP_416分割等和子集
 * @Description 给定一个只包含正整数的非空数组，是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *              注意：每个数组中的元素不会超过100，数组的大小不会超过200。
 * @Author Administrator
 * @Date 2021-12-02 15:01
 * @Version 1.0.0
 */
public class DP_416分割等和子集 {
    /**
     * 思路1：只要找到集合里能够出现 sum / 2 的子集总和即可，回溯法暴力搜索。
     * 思路2：01背包，可以这样理解，有N件物品和一个容量为 sum / 2 背包，要求背包放满。
     *
     *  动规五部曲：
     *  1. 确定dp数组以及下标的含义
     *  01背包中，dp[j]表示: 容量为j的背包，所背的物品价值可以最大为dp[j]。
     *  dp[j]: 表示背包总容量是j，最大可以凑成j的子集总和为dp[j]。
     *  2. 确定递推公式
     *  01背包的递推公式为: dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
     *  dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
     *  3. 如何初始化
     * 在01背包中，从dp[j]的定义来看，首先dp[0]一定是0.
     * 如果题目给定的价值都是正整数，那么非0下标都初始化为0就可以了，如果题目给的价值有负数，那么非0下标就要初始化为负无穷。
     * 这样才能让dp数组在递归公式的过程中取得最大的价值，而不是被初始值覆盖了。
     * 本题中，只包含正整数得非空数组，所以非0下标得元素初始化为0就可以了。
     *  dp[j] = 0;
     *
     *  4. 遍历顺序
     *  物品遍历放在外层，遍历背包放在内层，且内层for循环倒序遍历
     *
     *  5. 举例推导dp数组
     *
     */
    public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j -nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
