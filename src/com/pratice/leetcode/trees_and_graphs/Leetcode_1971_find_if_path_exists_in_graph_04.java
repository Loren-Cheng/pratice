package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1971_find_if_path_exists_in_graph_04 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        boolean[] seen;
        List<Integer>[] undirectedEdges = new List[n];
        seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            undirectedEdges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (undirectedEdges[u] != null) undirectedEdges[u].add(v);
            if (undirectedEdges[v] != null) undirectedEdges[v].add(u);
        }

        seen[source] = true;
        return dfs(source, destination, false, seen, undirectedEdges);
    }

    boolean dfs(int source, int destination, boolean valid, boolean[] seen, List<Integer>[] undirectedEdges) {
        if (undirectedEdges[source] != null) {
            for (int neighbor : undirectedEdges[source]
            ) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    valid = valid || neighbor == destination || dfs(neighbor, destination, valid, seen, undirectedEdges);
                }
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        //Leetcode_1971_find_if_path_exists_in_graph_01 a = new Leetcode_1971_find_if_path_exists_in_graph_01();
        //System.out.println(a.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        //Leetcode_1971_find_if_path_exists_in_graph_01 b = new Leetcode_1971_find_if_path_exists_in_graph_01();
        //System.out.println(b.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
        //Leetcode_1971_find_if_path_exists_in_graph_01 b = new Leetcode_1971_find_if_path_exists_in_graph_01();
        //System.out.println(b.validPath(10, new int[][]{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}}, 5, 9));
        Leetcode_1971_find_if_path_exists_in_graph_04 b = new Leetcode_1971_find_if_path_exists_in_graph_04();
        System.out.println(b.validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));
    }
}
