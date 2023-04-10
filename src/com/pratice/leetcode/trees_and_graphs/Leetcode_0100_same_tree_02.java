package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayDeque;

public class Leetcode_0100_same_tree_02 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null & q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
