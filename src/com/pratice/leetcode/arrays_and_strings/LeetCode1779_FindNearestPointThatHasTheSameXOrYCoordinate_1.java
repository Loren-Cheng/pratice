package com.pratice.leetcode.arrays_and_strings;

public class LeetCode1779_FindNearestPointThatHasTheSameXOrYCoordinate_1 {
    //1779. Find Nearest Point That Has the Same X or Y Coordinate
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                //distance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y)
                if (Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y) < min) {
                    min = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        int[][] b = new int[][]{{2, 3}};
        int[][] c = new int[][]{{3, 4}};
        System.out.println(nearestValidPoint(3, 4, a));
    }
}
