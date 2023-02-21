package com.pratice.leetcode.trees_and_graphs;

import java.util.Stack;

public class Leetcode_1448_count_good_nodes_in_binary_tree_02 {
    class Pair {
        TreeNode node;
        int maxSoFar;

        Pair(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int goodNodesNum = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));

        while (!stack.empty()) {
            Pair curr = stack.pop();
            if (curr.node.val >= curr.maxSoFar) {
                goodNodesNum++;
            }

            if (curr.node.right != null) {
                stack.push(new Pair(curr.node.right, Math.max(curr.maxSoFar, curr.node.right.val)));
            }
            if (curr.node.left != null) {
                stack.push(new Pair(curr.node.left, Math.max(curr.maxSoFar, curr.node.left.val)));
            }
        }
        return goodNodesNum;
    }
}

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



