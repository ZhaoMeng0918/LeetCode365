package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_子集问题_78子集
 * @Description 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 子集问题
 * 如果把子集问题、组合问题、分割问题都抽象为一棵树的话，
 * 那么组合问题和分割问题都是收集树的叶子结点，而子集问题是找树的所有节结点。
 * @Author Administrator
 * @Date 2021-12-07 14:22
 * @Version 1.0.0
 */
public class Backtracking_子集问题_78子集 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        subsetsHelper(nums, 0);
        return res;
    }

    private void subsetsHelper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path)); // 遍历树的时候，把所有节点都记录下来，就是要求的子集集合。
        if(startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
}
