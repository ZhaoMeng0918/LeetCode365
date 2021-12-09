package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_排列问题_46_全排列
 * @Description 给定一个没有重复数字的序列，返回其所有可能的全排列
 * @Author Administrator
 * @Date 2021-12-08 15:20
 * @Version 1.0.0
 */
public class Backtracking_排列问题_46_全排列 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] flag; // 标记哪些元素使用过

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        flag = new boolean[nums.length];
        permuteHelper(nums);
        return res;
    }

    private void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            flag[i] = false;
        }
    }
}
