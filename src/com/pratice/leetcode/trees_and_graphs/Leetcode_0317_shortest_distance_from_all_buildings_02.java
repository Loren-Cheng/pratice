package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode_0317_shortest_distance_from_all_buildings_02 {
    HashMap<Double, Integer> shortestDistanceList = new HashMap<>();
    List<int[]> buildingList;
    int buildingCount;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int min = Integer.MAX_VALUE;

    public int shortestDistance(int[][] grid) {
        buildingList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = j;
                int y = i;
                if (grid[y][x] == 1) {
                    buildingList.add(new int[]{x, y});
                    //store building coordinate
                }
            }
        }
        buildingCount = buildingList.size();

        for (int[] building : buildingList) {
            int buildCoordinateX = building[0];
            int buildCoordinateY = building[1];
            bfsToStoreShortestDist(grid, buildCoordinateX, buildCoordinateY);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = j;
                int y = i;

                if (valid(grid, x, y)
                        && grid[y][x] == 0
                ) {
                    //neighbor of node in the grid and is empty land
                    int sum = 0;
                    int count = 0;
                    for (int[] building : buildingList
                    ) {
                        //find the building
                        int buildingX = building[0];
                        int buildingY = building[1];
                        int dist = shortestDistanceList.getOrDefault((Math.pow(x + 137, 4)) + (Math.pow(y + 137, 3)) + (Math.pow(buildingX + 137, 2)) + (Math.pow(buildingY + 137, 1)), 0);
                        //hashing but collision

                        if (dist > 0) {
                            count++;
                            sum += dist;
                        }
                    }

                    if (count == buildingCount) {
                        min = Math.min(min, sum);
                    }
                }

            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void bfsToStoreShortestDist(int[][] grid, int oriX, int oriY) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int level = 0;
        List<int[]> thisLevel = new ArrayList<>();

        thisLevel.add(new int[]{oriX, oriY});
        while (!thisLevel.isEmpty()) {
            level++;
            List<int[]> nextLevel = new ArrayList<>();
            for (int[] node : thisLevel
            ) {
                int nodeX = node[0];
                int nodeY = node[1];
                for (int[] direction : directions
                ) {
                    int neighborX = nodeX + direction[1];
                    int neighborY = nodeY + direction[0];
                    if (valid(grid, neighborX, neighborY) && !seen[neighborY][neighborX]) {
                        seen[neighborY][neighborX] = true;
                        if (grid[neighborY][neighborX] == 0) {
                            shortestDistanceList.put((Math.pow(neighborX + 137, 4)) + (Math.pow(neighborY + 137, 3)) + (Math.pow(oriX + 137, 2)) + (Math.pow(oriY + 137, 1)), level);
                            //hashing but collision
                            nextLevel.add(new int[]{neighborX, neighborY});
                        }
                    }
                }
            }
            thisLevel = nextLevel;
        }
    }

    boolean valid(int[][] grid, int x, int y) {
        return x >= 0
                && x < grid[0].length
                && y >= 0
                && y < grid.length;
    }
}