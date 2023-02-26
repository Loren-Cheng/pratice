package com.pratice.leetcode.trees_and_graphs;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Leetcode_098_validate_binary_search_tree_01 {
    public boolean isValidBST(TreeNode root) {
        long low = Long.MIN_VALUE;
        long high = Long.MAX_VALUE;
        return dfs(root, low, high);
    }

    boolean dfs(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low) {
            return false;
        }
        if (root.val >= high) {
            return false;
        }
        boolean left = dfs(root.left, low, root.val);
        boolean right = dfs(root.right, root.val, high);

        return (right && left);
    }
}
