package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backtracking_排列问题_46_全排列_解法2
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-08 15:36
 * @Version 1.0.0
 */
public class Backtracking_排列问题_46_全排列_解法2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        permuteHelper(nums);
        return res;
    }

    private void permuteHelper(int[] nums) {
        if (path.size() == nums.length) res.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            // 通过判断path中是否存在数字，排除已经选择的数字
            // 解法1效率更高一些
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
        }
    }
}
