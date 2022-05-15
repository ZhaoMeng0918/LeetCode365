package com.leetcode;

public class LeetCode_数组_59_螺旋矩阵II {
    public static int[][] generateMatrix(int n) {
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int[][] result = new int[n][n];
        int count = 1;
        while (count <= n * n) {
            // 上
            for (int i = left; i <= right; i++) {
                result[top][i] = count;
                count++;
            }
            top++;

            // 右
            for (int i = top; i <= bottom; i++) {
                result[i][right] = count;
                count++;
            }
            right--;

            // 下
            for (int i = right; i >= left; i--) {
                result[bottom][i] = count;
                count++;
            }
            bottom--;

            // 左
            for (int i = bottom; i >= top; i--) {
                result[i][left] = count;
                count++;
            }
            left++;
        }
        return result;
    }
}
