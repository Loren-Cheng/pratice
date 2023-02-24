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

public class Leetcode_0938_range_sum_of_bst_01 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (low < root.val) {
            if (root.left != null) {
                sum += rangeSumBST(root.left, low, high);
            }
        }
        if (high > root.val) {
            if (root.right != null) {
                sum += rangeSumBST(root.right, low, high);
            }
        }
        return sum;
    }
}
