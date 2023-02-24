package com.pratice.leetcode.trees_and_graphs;


import java.util.ArrayList;

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
public class Leetcode_0530_minimum_absolute_difference_in_bst_01 {
    ArrayList<Integer> list = new ArrayList<>();
    int diffMin = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size() - 1; i++) {
            diffMin = Math.min(diffMin, list.get(i + 1) - list.get(i));
        }
        return diffMin;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            int left = getMinimumDifference(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            int right = getMinimumDifference(root.right);
        }
    }
}
