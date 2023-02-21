package com.pratice.leetcode.trees_and_graphs;

import java.util.Stack;

public class Leetcode_1448_count_good_nodes_in_binary_tree_01 {
    Stack<Integer> stack = new Stack<>();
    int counter = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        stack.push(root.val);
        goodNodes(root.left);
        goodNodes(root.right);
        int x = root.val;
        int count = 0;
        if (!stack.isEmpty()) {
            for (int n : stack
            ) {
                if (n > x) {
                    count++;
                }
            }
            stack.pop();
            if (count != 0) {
                return 0;
            } else {
                counter++;
            }
        }
        return counter;
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



