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
public class Leetcode_0530_minimum_absolute_difference_in_bst_02 {
    ArrayList<Integer> list = new ArrayList<>();
    int diffMin = Integer.MAX_VALUE;
    int prev = -1;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return diffMin;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            int left = getMinimumDifference(root.left);
        }
        if(prev == -1){

        }else {
            diffMin = Math.min(diffMin, root.val - prev);
        }
        prev = root.val;
        list.add(root.val);
        if (root.right != null) {
            int right = getMinimumDifference(root.right);
        }
    }
}
