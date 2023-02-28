package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0547_number_of_provinces_02 {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
            for (int j = i + 1; j < n; j++) {
                if (!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
                }
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        seen = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                seen[i] = true;
                ans++;
                bfs(i);
            }
        }
        return ans;
    }

    void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int n : graph.get(node)
            ) {
                if (!seen[n]) {
                    seen[n] = true;
                    queue.offer(n);
                }
            }
        }
    }
}
