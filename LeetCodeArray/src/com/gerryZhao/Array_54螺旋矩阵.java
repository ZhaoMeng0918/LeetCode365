package com.gerryZhao;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Array_54螺旋矩阵
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-09 14:38
 * @Version 1.0.0
 */
public class Array_54螺旋矩阵 {
    /**
     * 面试题中出现频率比较高的一道题
     * 本题并不涉及什么算法，就是模拟过程，但却十分考察对代码的掌控能力。
     *
     * 对于n * n有两种：
     * n为偶数，loop循环两次即可，也就是有两个完整的环
     * x x x x
     * x x x x
     * x x x x
     * x x x x
     *
     * n为奇数，loop循环以后还剩一个
     * x x x x x
     * x x x x x
     * x x x x x
     * x x x x x
     * x x x x x
     *
     * 对于m * n的，且m != n
     *
     * x x x x x
     * x x x x x
     * x x x x x
     * x x x x x
     *
     * m < n 且 n 为偶数，也是会凑成完整的环
     *
     * x x x x x x
     * x x x x x x
     * x x x x x x
     * x x x x x x
     * x x x x x x
     *
     * m < n 但是 n == 5 为奇数，所以最后还有一行
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        // 循环次数
        int loop = Math.min(m, n) / 2;

        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        while (loop-- > 0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右 [）
            for (; j < startY + n - offset; j++) {
                res.add(matrix[i][j]);
            }

            // 模拟右侧从上到下 [）
            for (; i < startX + m - offset; i++) {
                res.add(matrix[i][j]);
            }

            // 模拟下侧从右到左 [）
            for (; j > startY; j--) {
                res.add(matrix[i][j]);
            }

            // 模拟左侧从下到上 [）
            for (; i > startX; i--) {
                res.add(matrix[i][j]);
            }

            startX++;
            startY++;

            offset += 2;
        }

        // 若为n * n，且 n 为奇数
        if (m == n && m % 2 == 1) {
            res.add(matrix[n / 2][n / 2]);
        }

        // 针对列大于行，行不是偶数的时候
        if (n > m && m % 2 != 0) {
            // m / 2 == loop的次数，两边减去loop的次数
            for (int i = m / 2; i < n - m / 2; i++) {
                res.add(matrix[m / 2][i]);
            }
        }

        // 针对行大于列，列不是偶数的时候
        if (m > n && n % 2 != 0) {
            for (int i = n / 2; i < m - n / 2; i++) {
                res.add(matrix[i][n / 2]);
            }
        }

        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
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
