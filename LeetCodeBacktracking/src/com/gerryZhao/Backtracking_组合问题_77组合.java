package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_组合问题_77组合
 * @Description 给定两个整数n和k，返回1...n中所有可能的k个数的组合。
 * @Author Administrator
 * @Date 2021-12-06 15:18
 * @Version 1.0.0
 */
public class Backtracking_组合问题_77组合 {
    List<List<Integer>> result = new ArrayList<>(); // 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>(); // 用来存放符合条件的结果

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    private void combineHelper(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // for (int i = startIndex; i <= n; i++)
        // 剪枝优化
        for (int i = startIndex; i < n - (k - path.size()) + 1; i++) {
            path.add(i);
            combineHelper(n, k, i+1);
            path.removeLast();
        }
    }
}
