package com.gerryZhao;

/**
 * @ClassName Array_59螺旋矩阵II
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-09 11:51
 * @Version 1.0.0
 */
public class Array_59螺旋矩阵II {
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
     */

    /**
     * 模拟顺时针画矩阵的过程：
     * 上：左->右
     * 右：上->下
     * 下：右->左
     * 左：下->上
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        // 循环次数
        int loop = n / 2;

        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 1;

        // 定义中间位置
        int mid = n / 2;

        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右
            for (; j < startY + n - offset; j++) {
                res[startX][j] = count++;
            }

            // 模拟右侧从上到下
            for (; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从上到下
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;

            // 第二圈开始的时候，起始位置要各自+1
            startX += 1;
            startY += 1;

            // offset控制每一圈里每一条边遍历的长度
            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }

    /**
     *
     *         t
     *    l          r
     *         b
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++;
            }
            t++;

            for (int i = t; i <=b ; i++) {
                mat[i][r] = num++;
            }
            r--;

            for (int i = r; i >= l ; i--) {
                mat[b][i] = num++;
            }
            b--;

            for (int i = b; i >= t ; i--) {
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }
}
