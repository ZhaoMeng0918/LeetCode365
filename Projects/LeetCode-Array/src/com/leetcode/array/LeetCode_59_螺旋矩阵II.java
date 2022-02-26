package com.leetcode.array;

/**
 * @ClassName LeetCode_59_螺旋矩阵II
 * @Description 给定一个正整数n，生成一个包含1到n^2所有元素，且元素按照顺时针顺序螺旋排列的正方形矩阵。
 * @Author Administrator
 * @Date 2022-02-26 14:34
 * @Version 1.0.0
 */
public class LeetCode_59_螺旋矩阵II {
    /**
     * 模拟
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];
        int topIndex = 0;
        int rightIndex = n - 1;
        int bottomIndex = n - 1;
        int leftIndex = 0;
        int count = 1;
        while (count <= n * n) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                res[topIndex][i] = count++;
            }
            topIndex++;

            for (int i = topIndex; i <= bottomIndex; i++) {
                res[i][rightIndex] = count++;
            }
            rightIndex--;

            for (int i = rightIndex; i >= leftIndex; i--) {
                res[bottomIndex][i] = count++;
            }
            bottomIndex--;

            for (int i = bottomIndex; i >= topIndex; i--) {
                res[i][leftIndex] = count++;
            }
            leftIndex++;
        }
        return res;
    }

    /**
     * 模拟2
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];
        int loop = n / 2;
        int startX = 0;
        int startY = 0;
        int offset = 1;
        int count = 1;
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            for (; j < startY + n - offset; j++) {
                res[startX][j] = count++;
            }

            for (; j > startX + n - offset; i++) {
                res[i][j] = count++;
            }

            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;

            startX++;
            startY++;

            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_59_螺旋矩阵II lc = new LeetCode_59_螺旋矩阵II();
        int[][] res = lc.generateMatrix1(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
