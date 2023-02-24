package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0103_binary_tree_zigzag_level_order_traversal_01 {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null) {
            helper(root);
        }
        return ans;
    }

    public void helper(TreeNode root) {
        if (root != null) {
            queue.offer(root);
        }

        boolean flag = true;

        while (!queue.isEmpty()) {
            int nodesNumInThisLevel = queue.size();
            List<Integer> valList = new ArrayList<>();

            for (int i = 0; i < nodesNumInThisLevel; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                valList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (flag) {
                flag = false;
                ans.add(valList);
            } else {
                flag = true;
                Collections.reverse(valList);
                ans.add(valList);
            }
        }
    }
}
