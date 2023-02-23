package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_1302_deepest_leaves_sum_02 {
    int sum = 0;
    int maxDepth = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return sum;
    }

    public void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
        if (depth > maxDepth) {
            maxDepth = depth;
            sum = 0;
            sum += root.val;
        } else if (depth == maxDepth) {
            sum += root.val;
        }

    }
}
