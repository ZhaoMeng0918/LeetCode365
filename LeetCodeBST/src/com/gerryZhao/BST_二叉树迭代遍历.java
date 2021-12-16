package com.gerryZhao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST_二叉树迭代遍历
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-11 11:13
 * @Version 1.0.0
 */
public class BST_二叉树迭代遍历 {
    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null)  stack.push(node.left);
        }
        return result;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {   // 指针来访问结点，访问到最底层
                stack.push(cur); // 将访问的结点放进栈
                cur = cur.left;  // 左
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    /**
     * 后序遍历
     * 后序遍历顺序 左-右-中，入栈顺序 中-左-右 出栈顺序 中-右-左，最后反转结果
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);                           // 中
            if (node.left != null)  stack.push(node.left);  // 左
            if (node.right != null) stack.push(node.right); // 右
        }
        Collections.reverse(result);
        return result;
    }
}
