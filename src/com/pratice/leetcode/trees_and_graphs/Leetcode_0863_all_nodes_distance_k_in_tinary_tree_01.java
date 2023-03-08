package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Leetcode_0863_all_nodes_distance_k_in_tinary_tree_01 {
    Map<Integer, List<Integer>> adjacencyList;
    List<Integer> thisLevel = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        adjacencyList = new HashMap<>();
        dfs(root);
        //visit all child to store adjacency list
        if (target != null) {
            bfs(target.val, k);
        }
        return thisLevel;
    }

    void bfs(int target, int targetLevel) {
        int count = 0;
        thisLevel.add(target);
        seen.add(target);
        if (count == targetLevel) {
            return;
        }
        List<Integer> nextLevel;
        do {
            nextLevel = new ArrayList<>();
            List<Integer> neighbor = new ArrayList<>();
            for (int i = 0; i < thisLevel.size(); i++) {
                if(adjacencyList.containsKey(thisLevel.get(i))){
                    neighbor.addAll(adjacencyList.get(thisLevel.get(i)));
                }
            }
//            for (Integer integer : thisLevel) {
//                if (adjacencyList.containsKey(integer)) {
//                    neighbor.addAll(adjacencyList.get(integer));
//                }
//            }

            for (int i = 0; i < neighbor.size(); i++) {
                if(!seen.contains(neighbor.get(i))){
                    seen.add(neighbor.get(i));
                    nextLevel.add(neighbor.get(i));
                }
            }
//            for (Integer integer : neighbor) {
//                if (!seen.contains(integer)) {
//                    seen.add(integer);
//                    nextLevel.add(integer);
//                }
//            }
            count++;
            thisLevel = nextLevel;
        } while (count != targetLevel);
    }

    void dfs(TreeNode from) {
        if (from != null) {
            int u = from.val;
            List<Integer> uToV = adjacencyList.getOrDefault(u, new ArrayList<>());

            if (from.left != null) {
                dfs(from.left);
                int v = from.left.val;
                uToV.add(v);
                adjacencyList.put(u, uToV);
                List<Integer> vToU = adjacencyList.getOrDefault(v, new ArrayList<>());
                vToU.add(u);
                adjacencyList.put(v, vToU);
            }
            if (from.right != null) {
                dfs(from.right);
                int v = from.right.val;
                uToV.add(v);
                adjacencyList.put(u, uToV);
                List<Integer> vToU = adjacencyList.getOrDefault(v, new ArrayList<>());
                vToU.add(u);
                adjacencyList.put(v, vToU);
            }
        }
    }
}
