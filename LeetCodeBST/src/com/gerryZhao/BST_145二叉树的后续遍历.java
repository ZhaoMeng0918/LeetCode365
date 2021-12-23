package com.gerryZhao;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @ClassName BST_145二叉树的后续遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-22 20:13
 * @Version 1.0.0
 */
public class BST_145二叉树的后续遍历 {
    /**
     * 递归遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(root, res);
        return res;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postOrderTraversal(root.left, res);
        postOrderTraversal(root.right, res);
        res.add(root.val);
    }

    /**
     * 迭代
     * 前序遍历：中->左->右 ----->中->右->左------->后序遍历：左->右->中
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        // 主要思想：
        // 由于在某棵子树访问完成以后，接着就要回溯到其父结点去
        // 因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的结点是否为右子树
        while (root != null || !stack.isEmpty()) {
            // 先走到left叶子结点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.poll(); // left叶子结点

            // 现在需要确定的是是否有右子树，或者右子树是否也访问过
            // 如果没有右子树，或者右子树访问完了，也就是上一个访问的结点是右子树时
            // 说明可以访问当前结点
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                // 更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                prev = root;
                root = null;
            } else {
                // 如果右子树没有被访问，那么将当前节点压栈，访问右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
