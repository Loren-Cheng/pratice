package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_0101_symmetric_tree_01 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        return (leftNode.val == rightNode.val)
                && dfs(leftNode.left, rightNode.right)
                && dfs(leftNode.right, rightNode.left);
    }
}
