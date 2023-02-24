package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0199_binary_tree_right_side_view_01 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodesNumInThisLevel = queue.size();
            for (int i = 0; i < nodesNumInThisLevel; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    if (i == nodesNumInThisLevel - 1) {
                        ans.add(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return ans;
    }
}
