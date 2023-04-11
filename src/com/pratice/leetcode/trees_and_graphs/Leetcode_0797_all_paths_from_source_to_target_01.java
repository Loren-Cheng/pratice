package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0797_all_paths_from_source_to_target_01 {
    static List<List<Integer>> allPaths = new ArrayList<>();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int source = 0;
        int target = graph.length - 1;
        for (int neighbor : graph[0]) {
            Stack<Integer> tmpPath = new Stack<>();
            tmpPath.add(0);
            dfsFindTarget(neighbor, tmpPath, target, graph);//worst case < O(m^n) where m is average length of graph[i] and n is the length of graph
        }
        return allPaths;
    }

    static void dfsFindTarget(int entrance, Stack<Integer> tmpPath, int target, int[][] graph) {
        if(entrance != target) {
            tmpPath.add(entrance);
        } else {
            tmpPath.add(entrance);
            allPaths.add(tmpPath.stream().toList());
        }
        for (int neighbor : graph[entrance]) {
            dfsFindTarget(neighbor, tmpPath, target, graph);
            if(!tmpPath.isEmpty()) {
                tmpPath.pop();
            }

        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(a));
    }
}
