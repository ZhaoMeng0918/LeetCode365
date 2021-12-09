package com.gerryZhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_子集问题_90子集II
 * @Description 给定一个可能包含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 子集问题
 * @Author Administrator
 * @Date 2021-12-08 14:44
 * @Version 1.0.0
 */
public class Backtracking_子集问题_90子集II {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] flag;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return res;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) continue;
            path.add(nums[i]);
            flag[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            flag[i] = false;
        }
    }
}
