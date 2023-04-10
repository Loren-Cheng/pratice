package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_0104_maximum_depth_of_binary_tree_01 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 1;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left, level);
        }
        if (root.right != null) {
            right = dfs(root.right, level);
        }
        int max = Math.max(right, left);
        return Math.max(max, level);
    }

    int dfs(TreeNode root, int level) {
        if(root == null) return level;
        ++level;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left, level);
        }
        if (root.right != null) {
            right = dfs(root.right, level);
        }
        int max =  Math.max(right, left);
        return Math.max(max, level);
    }
}
