package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0103_binary_tree_zigzag_level_order_traversal_02 {
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<TreeNode> currLevel = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null) {
            helper(root);
        }
        return ans;
    }

    public void helper(TreeNode root) {
        int level = 1;

        if (root != null) {
            currLevel.add(root);
        }

        while (!currLevel.isEmpty()) {
            LinkedList<Integer> valList = new LinkedList<>();
            ArrayList<TreeNode> nextLevel = new ArrayList<>();

            for (TreeNode node : currLevel
            ) {
                if (node != null) {
                    if (level % 2 == 1) {
                        valList.addLast(node.val);
                    } else {
                        valList.addFirst(node.val);
                    }

                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
            }
            ans.add(valList);
            level++;
            currLevel = nextLevel;
        }
    }
}
