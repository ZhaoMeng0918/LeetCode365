package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_54_螺旋矩阵
 * @Description 给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @Author Administrator
 * @Date 2022-02-26 14:57
 * @Version 1.0.0
 */
public class LeetCode_54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        int num = 1;
        int total = matrix.length * matrix[0].length;
        while (num <= total) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                num++;
            }
            if (num > total) break;
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
                num++;
            }
            if (num > total) break;
            right--;
            for (int i = right; i >= left ; i--) {
                res.add(matrix[bottom][i]);
                num++;
            }
            if (num > total) break;
            bottom--;
            for (int i = bottom; i >= top ; i--) {
                res.add(matrix[i][left]);
                num++;
            }
            left++;
        }
        return res;
    }
}
