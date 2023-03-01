package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0200_number_of_islands_01 {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<String> seen = new HashSet<>();

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int ans = 0;

        for (int i = 0; i < row; i++) {
            int column = grid[i].length;
            for (int j = 0; j < column; j++) {
                String node = i + "," + j;
                if (!seen.contains(node)&&isValid(row,column,i,j,grid)) {
                    ans++;
                    seen.add(node);
                    dfs(node, grid, row, column);
                }
            }
        }
        return ans;
    }

    void dfs(String node, char[][] grid, int row, int column) {
        String[] coordinateS = node.split(",");
        int x = Integer.parseInt(coordinateS[0]);
        int y = Integer.parseInt(coordinateS[1]);
        int[] coordinateI = new int[]{x, y};

        for (int[] direction : directions
        ) {
            int neighborX = x + direction[0];
            int neighborY = y + direction[1];
            StringBuilder neighborNode = new StringBuilder(neighborX + "," + neighborY);

            if (isValid(row, column, neighborX, neighborY, grid) && !seen.contains(neighborNode.toString())) {
                seen.add(neighborNode.toString());
                dfs(neighborNode.toString(),grid,row,column);
            }
            //這個for 是固定4個方向的執行步驟=>o(1)
        }
    }

    static boolean isValid(int row, int column, int x, int y, char[][] grid) {
        return x >= 0 && x < row
                && y >= 0 && y < column
                && grid[x][y] == '1';
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};

        Leetcode_0200_number_of_islands_01 islands = new Leetcode_0200_number_of_islands_01();
        System.out.println(islands.numIslands(grid));
    }
}
