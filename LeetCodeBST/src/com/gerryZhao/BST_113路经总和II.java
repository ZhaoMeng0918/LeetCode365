package com.gerryZhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName BST_113路经总和II
 * @Description 给定一个二叉树和一个目标和，找到所有从根结点到叶子节点路径总和等于给定目标和的路径。
 * @Author Administrator
 * @Date 2021-12-21 20:06
 * @Version 1.0.0
 */
public class BST_113路经总和II {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        travesal(root, targetSum);
        return result;
    }

    private void travesal(TreeNode root, int count) {
//        // 简洁版
//        if (root == null) return;
//        path.offer(root.val);
//        count -= root.val;
//        if (root.left == null && root.right == null && count == 0) {
//            result.add(new ArrayList<>(path));
//        }
//        travesal(root.left, count);
//        travesal(root.right, count);
//        path.removeLast();

        if (root.left == null && root.right == null) {
            if (count == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            return;
        }

        if (root.left != null) {
            path.offer(root.left.val);
            count -= root.left.val;
            travesal(root.left, count);
            count += root.left.val;
            path.removeLast();
        }

        if (root.right != null) {
            path.offer(root.right.val);
            count -= root.right.val;
            travesal(root.right, count);
            count += root.right.val;
            path.removeLast();
        }

        return;
    }
}
