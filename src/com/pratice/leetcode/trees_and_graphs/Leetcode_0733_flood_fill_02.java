package com.pratice.leetcode.trees_and_graphs;

import java.util.Objects;

public class Leetcode_0733_flood_fill_02 {
    int color;
    int newColor;
    boolean[][] seen;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.color = image[sr][sc];
        this.newColor = color;
        seen = new boolean[image.length][image[0].length];
        int[] entrance = new int[]{sr, sc};
        image[sr][sc] = newColor;
        seen[sr][sc] = true;
        dfsFill(entrance, image);
        return image;
    }

    void dfsFill(int[] entrance, int[][] image) {
        for (int[] direction : directions
        ) {
            int row = entrance[0] + direction[0];
            int column = entrance[1] + direction[1];
            int[] neighbor = new int[]{row, column};
            if (checkNeighbor(neighbor, image)) {
                seen[row][column] = true;
                image[row][column] = newColor;
                dfsFill(neighbor, image);
            }
        }
    }

    boolean checkNeighbor(int[] neighbor, int[][] image) {
        int row = neighbor[0];
        int column = neighbor[1];
        if (row >= 0 && row < image.length && column >= 0 && column < image[0].length && !seen[row][column]) {
            return Objects.equals(image[neighbor[0]][neighbor[1]], color);
        }
        return false;
    }
}
