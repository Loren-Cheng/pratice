package com.pratice.leetcode.trees_and_graphs;

import com.pratice.leetcode.trees_and_graphs.TreeNode;

public class Leetcode_1339_maximum_product_of_splitted_binary_tree_01 {
    long max = Long.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        int sum = dfsSum(root);
        int modulo = (int) Math.pow(10, 9) + 7;
        int rmax = (int) (dfsMaxProduct(root, sum) % modulo);
        return rmax;
    }

    int dfsSum(TreeNode entrance) {
        if (entrance.left == null && entrance.right == null) return entrance.val;
        int left = 0;
        int right = 0;
        if (entrance.left != null) {
            left = dfsSum(entrance.left);
        }
        if (entrance.right != null) {
            right = dfsSum(entrance.right);
        }
        return entrance.val + left + right;
    }

    long dfsMaxProduct(TreeNode entrance, int totalSum) {
        if (entrance.left == null && entrance.right == null) return entrance.val;

        int leftSum = 0;
        int rightSum = 0;
        if (entrance.left != null) {
            leftSum = dfsSum(entrance.left);
        }
        if (entrance.right != null) {
            rightSum = dfsSum(entrance.right);
        }
        long leftSumProd = (long) leftSum * (totalSum - leftSum);
        long rightSumProd = (long) rightSum * (totalSum - rightSum);
        long tmpMax = Math.max(leftSumProd, rightSumProd);
        max = Math.max(max, tmpMax);
        if (entrance.left != null) {
            max = Math.max(max, dfsMaxProduct(entrance.left, totalSum));
        }
        if (entrance.right != null) {
            max = Math.max(max, dfsMaxProduct(entrance.right, totalSum));
        }
        return max;
    }
}
