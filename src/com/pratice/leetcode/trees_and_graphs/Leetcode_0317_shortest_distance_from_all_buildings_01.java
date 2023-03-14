package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode_0317_shortest_distance_from_all_buildings_01 {
    HashMap<String, Integer> shortestDistanceList = new HashMap<>();
    List<String> buildingList = new ArrayList<>();
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int min = Integer.MAX_VALUE;

    public int shortestDistance(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = j;
                int y = i;
                if (grid[y][x] == 1) {
                    StringBuilder buildingCoordinate = new StringBuilder(x + "," + y);
                    buildingList.add(buildingCoordinate.toString());
                    //store building coordinate
                }
            }
        }

        for (String building : buildingList) {
            String[] buildCoordinate = building.split(",");
            int buildCoordinateX = Integer.parseInt(buildCoordinate[0]);
            int buildCoordinateY = Integer.parseInt(buildCoordinate[1]);
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
                    for (String building : buildingList
                    ) {
                        //find the building
                        int dist = shortestDistanceList.getOrDefault(x + "," + y + "_" + building, 0);
                        if (dist > 0) {
                            count++;
                            sum += dist;
                        }
                    }
                    if (count == buildingList.size()) {
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
        List<String> thisLevel = new ArrayList<>();
        StringBuilder neighbor = new StringBuilder(oriX + "," + oriY);
        thisLevel.add(neighbor.toString());

        while (!thisLevel.isEmpty()) {
            level++;
            List<String> nextLevel = new ArrayList<>();
            for (String node : thisLevel
            ) {
                String[] neighborCoordinate = node.split(",");
                int nodeX = Integer.parseInt(neighborCoordinate[0]);
                int nodeY = Integer.parseInt(neighborCoordinate[1]);
                for (int[] direction : directions
                ) {
                    int neighborX = nodeX + direction[1];
                    int neighborY = nodeY + direction[0];
                    if (valid(grid, neighborX, neighborY) && !seen[neighborY][neighborX]) {
                        seen[neighborY][neighborX] = true;
                        if (grid[neighborY][neighborX] == 0) {
                            StringBuilder uToV = new StringBuilder(neighborX + "," + neighborY + "_" + oriX + "," + oriY);
                            shortestDistanceList.put(uToV.toString(),level);
                            nextLevel.add(neighborX + "," + neighborY);
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