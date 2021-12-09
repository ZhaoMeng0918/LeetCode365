package com.gerryZhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_组合问题_40组合总和II
 * @Description 给定一个数组和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 说明：所有数字都是正整数。解集不能包含重复的组合。
 * @Author Administrator
 * @Date 2021-12-07 14:21
 * @Version 1.0.0
 */
public class Backtracking_组合问题_40组合总和II {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    /**
     * 本题的难点在于：集合(数组candidates)有重复元素，但还不能有重复的组合。
     * 解决方案一：把所有组合求出来，再用set或者map去重。
     * 解决方案二：在搜索过程中去掉重复组合。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 为了将重复的数字都放在一起，所以先进行排序
        Arrays.sort(candidates);
        // 加标志数组，用来辅助判断同层结点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, flag);
        return res;
    }

    /**
     *
     * @param candidates
     * @param target
     * @param sum
     * @param startIndex
     * @param flag 标志数组，用来辅助判断同层结点是否已经遍历
     */
    private void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] flag) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // flag[i-1] == true; 说明同一树枝candidates[i-1]使用过
            // flag[i-1] == false; 说明同一树层candidates[i-1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) continue;
            flag[i] = true;
            sum += candidates[i];
            path.push(candidates[i]);
            backtracking(candidates, target, sum, i + 1, flag);
            int tmp = path.pop();
            flag[i] = false;
            sum -= tmp;
        }
    }
}
