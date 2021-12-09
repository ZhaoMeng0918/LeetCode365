package com.gerryZhao;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Backtracking_子集问题_491递增子序列
 * @Description 给定一个整数数组，你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2.
 * 说明：
 * 给定数组的长度不会超过15.
 * 数组中的整数范围是[-100, 100]。
 * 给定数组种可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * @Author Administrator
 * @Date 2021-12-08 14:52
 * @Version 1.0.0
 */
public class Backtracking_子集问题_491递增子序列 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            // 注意这里不能加return，因为要取树上所有的结点
        }
        // 采用Hash映射
        int[] flag = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            // () || 同一层使用过的结点不能再使用了
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || (flag[nums[i] + 100] == 1)) continue;
            flag[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            // 这里没有pop操作，是因为新的一层都会重新定义，所以flag只负责本层
        }
    }
}
