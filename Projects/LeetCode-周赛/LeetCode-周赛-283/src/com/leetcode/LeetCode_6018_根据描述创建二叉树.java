package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LeetCode_6018_根据描述创建二叉树
 * @Description 给你一个二维整数数组descriptions，
 * 其中descriptions[i] = [parenti, childi, isLefti]
 * 表示parenti是childi在 二叉树中的父节点，二叉树中各节点的值互不相同 。此外：
 * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
 * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
 * 请你根据descriptions的描述来构造二叉树并返回其根节点 。
 * 测试用例会保证可以构造出有效的二叉树。
 * @Author Administrator
 * @Date 2022-03-07 9:23
 * @Version 1.0.0
 */
public class LeetCode_6018_根据描述创建二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> chlids = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] d : descriptions) {
            int pVal = d[0], cVal = d[1];
            boolean left = (d[2] == 1) ? true : false;

            TreeNode pNode = map.get(pVal);
            if (pNode == null) {
                pNode = new TreeNode(pVal);
                map.put(pVal, pNode);
            }

            TreeNode cNode = map.get(cVal);
            if (cNode == null) {
                cNode = new TreeNode(cVal);
                map.put(cVal, cNode);
            }
            chlids.add(cVal);

            if (left) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }
        }
        TreeNode root = null;
        for (int v : map.keySet()) {
            if (chlids.contains(v)) continue;
            else {
                root = map.get(v);
                break;
            }
        }
        return root;
    }
}




