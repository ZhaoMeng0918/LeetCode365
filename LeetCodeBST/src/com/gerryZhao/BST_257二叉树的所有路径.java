package com.gerryZhao;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST_257二叉树的所有路径
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-20 18:43
 * @Version 1.0.0
 */
public class BST_257二叉树的所有路径 {
    private List<String> res = new ArrayList<>();
    private List<Integer> paths = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++)
                sb.append(paths.get(i)).append("->");
            sb.append(paths.get(paths.size()) - 1);
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right);
            paths.remove(paths.size() - 1);
        }
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null) return res;
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return res;
    }
}
