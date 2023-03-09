package com.pratice.leetcode.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1926_nearest_exit_from_entrance_in_maze_01 {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] seen;

    public int nearestExit(char[][] maze, int[] entrance) {
        seen = new boolean[maze.length][];
        for (int i = 0; i < seen.length; i++) {
            seen[i] = new boolean[maze[0].length];
        }
        return bfs(maze, entrance);
    }

    int bfs(char[][] maze, int[] entrance) {
        boolean toLeave = false;
        int level = 0;

        List<int[]> thisLevel = new ArrayList<>();
        thisLevel.add(entrance);
        seen[entrance[0]][entrance[1]] = true;

        while (true) {
            List<int[]> nextLevel = new ArrayList<>();
            for (int[] neighbor : thisLevel
            ) {
                int x = neighbor[1];
                int y = neighbor[0];

                if (toLeave) {
                    break;
                }
                for (int[] direction : directions
                ) {
                    int dX = direction[1];
                    int dY = direction[0];
                    int xX = x + dX;
                    int yY = y + dY;

                    if (xX >= 0 && xX < maze[0].length
                            && yY >= 0 && yY < maze.length
                            && maze[yY][xX] == '.'
                            && !seen[yY][xX]) {
                         //traverse the empty cell in the maze range and never seen before
                        seen[yY][xX] = true;
                        nextLevel.add(new int[]{yY, xX});
                    }

                    if (level > 0 && (xX < 0 || xX >= maze[0].length || yY < 0 || yY >= maze.length)) {
                        //outside the maze
                        toLeave = true;
                        break;
                    }
                }
            }
            if (nextLevel.size() == 0 && !toLeave) {
                // no empty cell and still in the maze
                return -1;
            } else if (nextLevel.size() == 0 && toLeave) {
                // no empty cell and touch the fence
                break;
            }

            if (toLeave) {
                break;
            }
            level++;
            thisLevel = nextLevel;
        }
        return level;
    }
}
