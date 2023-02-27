package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_0270_closest_binary_search_tree_value_02 {
    public int closestValue(TreeNode root, double target) {
        double minDistence = Integer.MAX_VALUE;
        int closet = Integer.MAX_VALUE;

        while (root != null) {
            double distance = Math.abs(target - root.val);
            closet = distance < minDistence ? root.val : closet;
            minDistence = Math.min(distance, minDistence);
            if (target < root.val) root = root.left;
            else root = root.right;
        }
        return closet;
    }
}
