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
public class Leetcode_0701_insert_into_a_binary_search_tree_01 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        int low = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        dfs(root, val, null, low, right);
        return root;
    }

    void dfs(TreeNode root, int val, TreeNode pri, int low, int high) {
        if (root == null) {
            if (pri != null) {
                if (val < pri.val) {
                    pri.left = new TreeNode(val);
                } else {
                    pri.right = new TreeNode(val);
                }
            } else {
                root = new TreeNode(val);
            }
            return;
        }

        if (val < root.val) {
            dfs(root.left, val, root, low, root.val);
        }
        if (val > root.val) {
            dfs(root.right, val, root, root.val, high);
        }
    }
}
