package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_1971_find_if_path_exists_in_graph_02 {
    boolean valid = false;
    boolean[] seen;
    Map<Integer, List<Integer>> undirectedEdges = new HashMap<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) return true;
        seen = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            List<Integer> uToV = undirectedEdges.getOrDefault(u, new ArrayList<>());
            uToV.add(v);
            undirectedEdges.put(u, uToV);
            List<Integer> vToU = undirectedEdges.getOrDefault(v, new ArrayList<>());
            vToU.add(u);
            undirectedEdges.put(v, vToU);
        }
        seen[source]= true;
        dfs(source, source, destination);
        return valid;
    }

    void dfs(int source, int from, int destination) {
        if (undirectedEdges.get(from) != null) {
            for (int neighbor : undirectedEdges.get(from)
            ) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    valid = neighbor == destination
                            || valid;
                    dfs(source, neighbor, destination);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        //Leetcode_1971_find_if_path_exists_in_graph_01 a = new Leetcode_1971_find_if_path_exists_in_graph_01();
        //System.out.println(a.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        //Leetcode_1971_find_if_path_exists_in_graph_01 b = new Leetcode_1971_find_if_path_exists_in_graph_01();
        //System.out.println(b.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
        //Leetcode_1971_find_if_path_exists_in_graph_01 b = new Leetcode_1971_find_if_path_exists_in_graph_01();
        //System.out.println(b.validPath(10, new int[][]{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}}, 5, 9));
        Leetcode_1971_find_if_path_exists_in_graph_02 b = new Leetcode_1971_find_if_path_exists_in_graph_02();
        System.out.println(b.validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));
    }
}
