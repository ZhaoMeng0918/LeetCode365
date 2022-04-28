package com.leetcode.dp;

public class LeetCode_96_不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 对于第 i 个节点，需要考虑从 1 开始作为根节点直到 i 作为根节点的情况，所以需要累加
                // 一共 i 个节点，对于根节点 j 时，左子树的节点个数为 j - 1， 右子树的节点个数为 i - j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
