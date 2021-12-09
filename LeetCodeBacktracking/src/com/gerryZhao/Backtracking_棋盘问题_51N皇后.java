package com.gerryZhao;

import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Backtracking_棋盘问题_51N皇后
 * @Description
 * @Author Administrator
 * @Date 2021-12-09 14:49
 * @Version 1.0.0
 */
public class Backtracking_棋盘问题_51N皇后 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) Arrays.fill(c, '.');
        backtracking(n, 0, chessboard);
        return res;
    }

    private void backtracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard)
            list.add(String.copyValueOf(c));
        return list;
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++)
            if (chessboard[i][col] == 'Q') return false;
        // 检查45°对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][col] == 'Q') return false;
        // 检查135°对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++)
            if (chessboard[i][col] == 'Q') return false;
        return true;
    }
}
