package com.pratice.leetcode.trees_and_graphs;


public class Leetcode_0200_number_of_islands_02 {
    public int numIslands(char[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row = grid.length;
        int column = grid[0].length;
        int ans = 0;
        boolean[][] seen = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!seen[i][j] && isValid(row, column, i, j, grid)) {
                    ans++;
                    seen[i][j] = true;
                    dfs(i, j, grid, row, column,directions,seen);
                }
            }
        }
        return ans;
    }

    void dfs(int x, int y, char[][] grid, int row, int column,int[][] directions, boolean[][] seen) {
        for (int[] direction : directions
        ) {
            int neighborX = x + direction[0];
            int neighborY = y + direction[1];


            if (isValid(row, column, neighborX, neighborY, grid) && !seen[neighborX][neighborY]) {
                seen[neighborX][neighborY] = true;
                dfs(neighborX, neighborY, grid, row, column,directions,seen);
            }
        }
    }

    static boolean isValid(int row, int column, int x, int y, char[][] grid) {
        return x >= 0 && x < row
                && y >= 0 && y < column
                && grid[x][y] == '1';
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};

        Leetcode_0200_number_of_islands_02 islands = new Leetcode_0200_number_of_islands_02();
        System.out.println(islands.numIslands(grid));

    }
}
