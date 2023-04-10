package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_0104_maximum_depth_of_binary_tree_02 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(right, left) + 1;
    }
}
