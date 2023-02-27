package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_0270_closest_binary_search_tree_value_01 {
    double minDistence = Integer.MAX_VALUE;
    int closetValue = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return closetValue;
    }

    public void dfs(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        double tmp = minDistence;
        minDistence = Math.min(minDistence, Math.abs(target - root.val));
        if (tmp != minDistence) {
            closetValue = root.val;
        }
        if (target < root.val) {
            dfs(root.left, target);
        }
        if (target > root.val) {
            dfs(root.right, target);
        }
    }
}
