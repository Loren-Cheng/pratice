package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_1339_maximum_product_of_splitted_binary_tree_02 {
    private long max = Long.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        int sum = dfsSum(root);
        int modulo = (int)Math.pow(10,9) + 7;
        dfs(root,sum);
        int rmax = Math.floorMod(max,modulo) ;
        return rmax;
 }

    void dfs(TreeNode node, int totalSum) {
        if(node.left != null){
            dfs(node.left, totalSum);
        }
        if(node.right != null){
            dfs(node.right, totalSum);
        }
        max = Math.max(max,dfsMaxProduct(node,totalSum));
    }

    int dfsSum(TreeNode entrance) {
        if(entrance.left == null && entrance.right == null) return entrance.val;
        int left = 0;
        int right = 0;
        if(entrance.left != null) {
            left = dfsSum(entrance.left);
        }
        if(entrance.right != null){
            right = dfsSum(entrance.right);
        }
        return entrance.val + left + right;
    }

    long dfsMaxProduct(TreeNode entrance, int totalSum) {
        int leftSum = 0;
        int rightSum = 0;
        if(entrance.left != null){
             leftSum = dfsSum(entrance.left);
        }
        if(entrance.right != null) {
            rightSum = dfsSum(entrance.right);
        }
        long leftSumProd = (long) leftSum *  (totalSum - leftSum);
        long rightSumProd = (long) rightSum *  (totalSum - rightSum);
        long tmpMax = Math.max(leftSumProd, rightSumProd);
        max = Math.max(max,tmpMax);
        return max;
    }
}
