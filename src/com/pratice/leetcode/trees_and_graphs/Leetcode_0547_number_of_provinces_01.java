package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_0547_number_of_provinces_01 {
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
        //將Adjacency matrix轉成Adjacency lists，space complexity 由O(n^2)降到o(n+m) n=>nodes m=>edges
        //在sparse graph下較省記憶體，在遍歷時也能較adjacency matrix減少要遍歷的節點數
        //但轉換本身會先花掉O(n^2)

        seen = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(!seen[i]){
                seen[i] = true;
                ans++;
                dfs(i);
            }
        }
        return ans;
    }
    void dfs(int node){
        for (int neighbor:graph.get(node)
             ) {
            if(!seen[neighbor]){
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}
