package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_0317_shortest_distance_from_all_buildings_03 {
    List<int[]> buildingList;
    int buildingCount;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
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

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = j;
                int y = i;
                if (x >= 0
                        && x < grid[0].length
                        && y >= 0
                        && y < grid.length
                        && grid[y][x] == 0
                ) {
                    int dist = bfsToStoreShortestDist(grid, j, i);
                    min = Math.min(min, dist);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    int bfsToStoreShortestDist(int[][] grid, int oriX, int oriY) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int count = 0;
        int level = 0;
        int sum = 0;
        List<int[]> thisLevel = new ArrayList<>();

        thisLevel.add(new int[]{oriX, oriY});

        while (!thisLevel.isEmpty()) {
            List<int[]> nextLevel = new ArrayList<>();
            level++;

            for (int[] node : thisLevel
            ) {
                int nodeX = node[0];
                int nodeY = node[1];
                for (int[] direction : directions
                ) {
                    int neighborX = nodeX + direction[1];
                    int neighborY = nodeY + direction[0];
                    if (neighborX >= 0
                            && neighborX < grid[0].length
                            && neighborY >= 0
                            && neighborY < grid.length && !seen[neighborY][neighborX]) {
                        seen[neighborY][neighborX] = true;
                        if (grid[neighborY][neighborX] == 0) {
                            nextLevel.add(new int[]{neighborX, neighborY});
                        }
                        if (grid[neighborY][neighborX] == 1) {
                            count++;
                            sum += level;
                            if (count == buildingCount) {
                                return sum;
                            }
                        }
                    }
                }
            }
            thisLevel = nextLevel;
        }
        return Integer.MAX_VALUE;
    }

    boolean valid(int[][] grid, int x, int y) {
        return x >= 0
                && x < grid[0].length
                && y >= 0
                && y < grid.length;
    }
}