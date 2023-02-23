package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_1026_maximum_difference_between_node_and_ancestor_01 {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode root, int currMax, int currMin) {
        if (root == null) {
            return currMax - currMin;
        }

        int result = 0;
        int possibleResult = Math.max(Math.abs(currMax - root.val), Math.abs(currMin - root.val));
        currMax = Math.max(currMax, root.val);
        currMin = Math.min(currMin, root.val);
        int left = helper(root.left, currMax, currMin);
        int right = helper(root.right, currMax, currMin);
        return Math.max(left, right);
    }
}
