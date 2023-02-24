package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_0199_binary_tree_right_side_view_03 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    public void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if(level == ans.size()){
            ans.add(root.val);
        }

        if (root.right != null) {
            helper(root.right, level + 1);
        }
        if (root.left != null) {
            helper(root.left, level + 1);
        }
    }
}
