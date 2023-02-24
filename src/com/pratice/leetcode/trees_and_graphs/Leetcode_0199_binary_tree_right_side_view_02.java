package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_0199_binary_tree_right_side_view_02 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        List<TreeNode> currLevel = new ArrayList<>();
        if(root != null) {
            currLevel.add(root);
        }

        while (!currLevel.isEmpty()) {
            ans.add(currLevel.get(currLevel.size() - 1).val);

            List<TreeNode> nextLevel = new ArrayList<>();

            for (TreeNode node : currLevel
            ) {
                if (node != null) {
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
            }
            currLevel = nextLevel;
        }
        return ans;
    }
}
