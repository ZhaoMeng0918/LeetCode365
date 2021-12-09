package com.gerryZhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_排列问题_47全排列II
 * @Description 给定一个可包含重复数字的序列nums，按任意顺序返回所有不重复的全排列。
 * @Author Administrator
 * @Date 2021-12-08 15:43
 * @Version 1.0.0
 */
public class Backtracking_排列问题_47全排列II {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    boolean[] flag;
    /**
     * 一般来说，组合问题和排列问题是在树形结构的叶子节点上收集结果，而子集问题就是取树上所有的结点。
     * 对于排列问题，树层上去重和树枝上去重，都是可以的，但是树层上去重效率更高
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        Arrays.fill(flag, false);
        backTracking(nums);
        return res;
    }

    private void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !flag[i - 1]) continue;
            flag[i] = true;
            path.add(nums[i]);
            backTracking(nums);
            path.removeLast();
            flag[i] = false;
        }
    }
}
