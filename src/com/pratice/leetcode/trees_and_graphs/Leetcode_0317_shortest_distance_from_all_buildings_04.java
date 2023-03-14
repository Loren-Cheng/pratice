package com.pratice.leetcode.trees_and_graphs;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_0317_shortest_distance_from_all_buildings_04 {
    public int shortestDistance(int[][] grid) {
        int[][][] buildingsStepsList;
        int buildingCount;
        int min = Integer.MAX_VALUE;
        List<int[]> buildingList = new LinkedList<>();

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
        buildingsStepsList = new int[buildingCount][grid.length][grid[0].length];

        for (int i = 0; i < buildingList.size(); i++) {
            int x = buildingList.get(i)[0];
            int y = buildingList.get(i)[1];
            bfsToStoreShortestDist(grid, x, y, i,buildingsStepsList);
        }

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int count = 0;
                int sum = 0;
                int x = i;
                int y = j;
                if (grid[y][x] == 0) {
                    for (int k = 0; k < buildingList.size(); k++) {
                        int dist = buildingsStepsList[k][y][x];
                        if (dist <= 0) {
                            break;
                        }
                            sum += dist;
                            count++;

                        if (count == buildingCount) {
                            min = Math.min(min, sum);
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void bfsToStoreShortestDist(int[][] grid, int oriX, int oriY, int buildingIndex,int[][][] buildingsStepsList) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int level = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        LinkedList<int[]> thisLevel = new LinkedList<>();

        thisLevel.add(new int[]{oriX, oriY});

        while (!thisLevel.isEmpty()) {
            level++;
            LinkedList<int[]> nextLevel = new LinkedList<>();

            for (int[] node : thisLevel) {
                int nodeX = node[0];
                int nodeY = node[1];
                for (int[] direction : directions) {
                    int neighborX = nodeX + direction[1];
                    int neighborY = nodeY + direction[0];
                    if (valid(grid, neighborX, neighborY)
                            && !seen[neighborY][neighborX]) {
                        if (grid[neighborY][neighborX] == 0) {
                            seen[neighborY][neighborX] = true;
                            buildingsStepsList[buildingIndex][neighborY][neighborX] = level;
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