package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1339_maximum_product_of_splitted_binary_tree_03 {
    private List<Integer> subTreeSumList = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        int sum = dfsSum(root);
        long max = Long.MIN_VALUE;
        for (int subTreeSum:subTreeSumList
        ) {
            max = Math.max(max,(long)subTreeSum*(sum - subTreeSum));
        }
        int modulo = (int)Math.pow(10,9) + 7;
        return Math.floorMod(max,modulo);
    }

    private int dfsSum(TreeNode entrance) {
        if(entrance.left == null && entrance.right == null) {
            subTreeSumList.add(entrance.val);
            return entrance.val;
        }
        int left = 0;
        int right = 0;
        if(entrance.left != null) {
            left = dfsSum(entrance.left);
        }
        if(entrance.right != null){
            right = dfsSum(entrance.right);
        }
        subTreeSumList.add(entrance.val + left + right);
        return entrance.val + left + right;
    }
}
