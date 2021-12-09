package com.gerryZhao;

import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_组合问题_39组合总和
 * @Description 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：所有数字都是正整数; 解集不能包含重复的组合
 * @Author Administrator
 * @Date 2021-12-06 15:20
 * @Version 1.0.0
 */
public class Backtracking_组合问题_39组合总和 {
    /* 15ms
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        backtracking(candidates, target, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        int count = count(tmp);
        if(count > target) {
            return;
        }
        if (count == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backtracking(candidates, target, i);
            tmp.removeLast();
        }
    }

    private int count(List<Integer> list) {
        int count = 0;
        for (int num : list) {
            count += num;
        }
        return count;
    }
    */

    // 2ms
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates,
                              int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
