package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
public class Leetcode_0111_minimum_depth_of_binary_tree_02 {
    class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        int minDepth = Integer.MAX_VALUE;
        Deque<Pair> stack = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair currNodeDepth = stack.pop();
            int depth = currNodeDepth.depth;
            TreeNode left = currNodeDepth.node.left;
            TreeNode right = currNodeDepth.node.right;
            if (left == null && right == null) {
                if (depth < minDepth) {
                    minDepth = depth;
                }
            }
            if (right != null) {
                stack.push(new Pair(right, depth + 1));
            }
            if (left != null) {
                stack.push(new Pair(left, depth + 1));
            }
        }
        return minDepth;
    }
}
