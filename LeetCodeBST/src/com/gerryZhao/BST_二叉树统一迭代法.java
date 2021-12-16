package com.gerryZhao;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST_二叉树统一迭代法
 * @Description 以中序遍历为例子，使用栈的话，无法同时解决访问结点和处理结点不一致的情况。
 * 那我们就将访问结点放入栈中，把要处理的结点也放入栈中但要做标记。
 * 如何标记？
 * 就是要处理的结点放入栈中之后，紧接着放入一个空指针作为标记。
 * @Author Administrator
 * @Date 2021-12-11 11:14
 * @Version 1.0.0
 */
public class BST_二叉树统一迭代法 {
    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop(); // 将该结点弹出，避免重复操作，下面再将右中左结点添加到栈中
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null); // 中结点访问过，但是还没有处理，加入空结点作为标记
            } else { // 只有遇到空结点的时候，才将下一个结点放入结果集
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    private List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

}
