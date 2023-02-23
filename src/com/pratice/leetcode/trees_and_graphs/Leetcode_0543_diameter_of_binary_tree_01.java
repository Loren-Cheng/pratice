package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_0543_diameter_of_binary_tree_01 {
    int diameterOfBinaryTree = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = maxDepth(root);
        return diameterOfBinaryTree;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left + right > diameterOfBinaryTree) {
            diameterOfBinaryTree = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
