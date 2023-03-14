package com.pratice.leetcode.trees_and_graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_0317_shortest_distance_from_all_buildings_05 {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

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
        int buildingCount = buildingList.size();
        int[][][] buildingsStepsMatrix = new int[buildingCount][grid.length][grid[0].length];

        for (int i = 0; i < buildingList.size(); i++) {
            int x = buildingList.get(i)[0];
            int y = buildingList.get(i)[1];
            bfsToStoreShortestDist(grid, x, y, i, buildingsStepsMatrix);
            //bfs every step in each building and store in the matrix
        }

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int count = 0;
                int sum = 0;
                int x = i;
                int y = j;
                if (grid[y][x] == 0) {
                    for (int k = 0; k < buildingCount; k++) {
                        int dist = buildingsStepsMatrix[k][y][x];
                        if (dist == 0) {
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

    void bfsToStoreShortestDist(int[][] grid, int oriX, int oriY, int buildingIndex, int[][][] buildingsStepsMatrix) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int level = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{oriX, oriY});

        while (!queue.isEmpty()) {
            level++;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int[] node = queue.poll();
                if (node != null) {
                    int col = node[0];
                    int row = node[1];
                    for (int[] direction : directions) {
                        int nextCol = col + direction[1];
                        int nextRow = row + direction[0];
                        if (valid(grid, nextCol, nextRow)
                                && !seen[nextRow][nextCol]) {
                            if (grid[nextRow][nextCol] == 0) {
                                seen[nextRow][nextCol] = true;
                                buildingsStepsMatrix[buildingIndex][nextRow][nextCol] = level;
                                queue.add(new int[]{nextCol, nextRow});
                            }
                        }
                    }
                }
            }
        }
    }

    boolean valid(int[][] grid, int x, int y) {
        return x >= 0
                && x < grid[0].length
                && y >= 0
                && y < grid.length;
    }
}