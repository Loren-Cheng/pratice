package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode_2368_reachable_nodes_with_restrictions_01 {
    List<Integer>[] undirectedEdges;
    int count = 0;
    boolean[] seen;
    HashSet<Integer> restrictedSet = new HashSet<>();

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        undirectedEdges = new List[n];
        seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            undirectedEdges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            undirectedEdges[edges[i][0]].add(edges[i][1]);
            undirectedEdges[edges[i][1]].add(edges[i][0]);
        }

        for (int restrect : restricted
        ) {
            restrictedSet.add(restrect);
        }

        if (0 < restricted[0] || 0 > restricted[1]) {
            count++;
        }
        dfs(0, restricted);
        return count;
    }

    void dfs(int from, int[] restricted) {
        seen[from] = true;
        for (int i = 0; i < undirectedEdges[from].size(); i++) {
            int neighbor = undirectedEdges[from].get(i);
            if (!seen[neighbor] && !restrictedSet.contains(neighbor)) {
                count++;
                dfs(neighbor, restricted);
            }
        }

    }
}
