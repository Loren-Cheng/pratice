package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leetcode_0872_leaf_similar_trees_01 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfsLeafList(list1, root1);
        dfsLeafList(list2, root2);

        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) return false;
        }
        return true;
    }

    void dfsLeafList(List<Integer> list, TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        if (node.left != null) {
            dfsLeafList(list, node.left);
        }
        if (node.right != null) {
            dfsLeafList(list, node.right);
        }
    }
}