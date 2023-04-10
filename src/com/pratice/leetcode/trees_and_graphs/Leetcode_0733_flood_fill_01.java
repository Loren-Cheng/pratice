package com.pratice.leetcode.trees_and_graphs;

import java.util.Arrays;

public class Leetcode_0733_flood_fill_01 {
    int[][] ans;
    boolean[][] seen;
    int color;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.color = color;
        ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                ans[i][j] = image[i][j];
            }
        }
        seen = new boolean[image.length][image[0].length];
        int[] entrance = new int[]{sr, sc};
        ans[sr][sc] = color;
        seen[sr][sc] = true;
        dfsFill(entrance, image);
        return ans;
    }

    void dfsFill(int[] entrance, int[][] image) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions
        ) {
            int row = entrance[0] + direction[0];
            int column = entrance[1] + direction[1];
            int[] neighbor = new int[]{row, column};
            if (checkNeighbor(neighbor, entrance, image)) {
                seen[row][column] = true;
                ans[row][column] = color;
                dfsFill(neighbor, image);
            }
        }

    }

    boolean checkNeighbor(int[] neighbor, int[] entrance, int[][] image) {
        int row = neighbor[0];
        int column = neighbor[1];
        if (row >= 0 && row < ans.length && column >= 0 && column < ans[0].length && !seen[row][column]) {
            if (image[entrance[0]][entrance[1]] == image[neighbor[0]][neighbor[1]]) return true;
        }
        return false;
    }
}
