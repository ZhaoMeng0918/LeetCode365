package com.leetcode.dp;

public class LeetCode_416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        // 第一步：求nums总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 第二步：01背包问题，取多少个数和为num
        // 背包体积为 sum / 2
        // 背包要放入的商品重量为元素的数值，价值也为元素的数值
        // 背包如果正好装满，说明找到了总和为 sum / 2 的子集
        // 背包中每一个元素是不可重复放入的
        int target = sum /2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;

    }
}
