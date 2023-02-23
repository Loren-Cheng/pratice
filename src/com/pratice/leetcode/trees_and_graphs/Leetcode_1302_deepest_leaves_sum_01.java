package com.pratice.leetcode.trees_and_graphs;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1302_deepest_leaves_sum_01 {
    Map<Integer, Integer> leavesDepthAndValSum = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int maxDepth = helper(root, 1);
//        for (Map.Entry<Integer, Integer> entry : leavesDepthAndValSum.entrySet()
//        ) {
//            maxDepth = Math.max(maxDepth, entry.getKey());
//        }
        return leavesDepthAndValSum.getOrDefault(maxDepth, root.val);
    }

    public int helper(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (root.left == null && root.right == null) {
            leavesDepthAndValSum.put(depth, leavesDepthAndValSum.getOrDefault(depth, 0) + root.val);
        }
        return Math.max(left, right) + 1;
    }
}
