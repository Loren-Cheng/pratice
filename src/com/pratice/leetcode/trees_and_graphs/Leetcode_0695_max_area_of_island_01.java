package com.pratice.leetcode.trees_and_graphs;

public class Leetcode_0695_max_area_of_island_01 {
    int maxArea = 0;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {0, 0}};
    boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!seen[i][j] && grid[i][j] == 0) {
                    seen[i][j] = false;
                } else {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int x, int y) {
        int thisArea = 0;

        for (int[] direction : directions
        ) {
            int tmpX = x + direction[0];
            int tmpY = y + direction[1];
            if (tmpX >= 0 && tmpX < grid.length
                    && tmpY >= 0 && tmpY < grid[0].length
                    && !seen[tmpX][tmpY]) {
                seen[tmpX][tmpY] = true;
                if (grid[tmpX][tmpY] == 1) {
                    thisArea = thisArea + dfs(grid, tmpX, tmpY);
                    thisArea++;
                }
            }
        }

        return thisArea;
    }
}
