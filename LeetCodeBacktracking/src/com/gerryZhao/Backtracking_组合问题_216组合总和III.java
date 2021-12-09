package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_组合问题_216组合总和III
 * @Description 找出所有相加之和为n的k个数的组合。组合中只允许含有1-9的正整数，并且每种组合中不存在重复的数字。
 * 说明：所有数字都是正整数; 解集不能包含重复的组合。
 * @Author Administrator
 * @Date 2021-12-06 15:19
 * @Version 1.0.0
 */
public class Backtracking_组合问题_216组合总和III {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1, 0);
        return res;
    }

    private void backtracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) return;
        if(path.size() == k) {
            if (sum == targetSum) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(targetSum, k, i+1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
