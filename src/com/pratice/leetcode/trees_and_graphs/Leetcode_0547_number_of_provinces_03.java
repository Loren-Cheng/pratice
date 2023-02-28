package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0547_number_of_provinces_03 {

    public static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] seen = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                bfs(i, seen, isConnected);
                ans++;
            }
        }
        return ans;
    }

    static void bfs(int node, boolean[] seen, int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (!seen[node]) {
                seen[node] = true;
                int[] thisLevel = isConnected[node];
                for (int i = 0; i < thisLevel.length; i++) {
                    if (!seen[i] && thisLevel[i] == 1) {
                        queue.offer(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}

