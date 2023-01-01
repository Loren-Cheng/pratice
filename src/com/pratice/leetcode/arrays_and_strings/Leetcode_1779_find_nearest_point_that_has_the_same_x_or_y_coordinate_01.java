package com.pratice.leetcode.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1779_find_nearest_point_that_has_the_same_x_or_y_coordinate_01 {

    public static int nearestValidPoint(int x, int y, int[][] points) {
        List<int[]> tmp = new ArrayList<>();

        for (int[] e : points) {
            if (e[0] == x || e[1] == y) {
                tmp.add(e);
            }
        }
        int min = Integer.MAX_VALUE;
        int count = -1;
        int[] t = new int[0];


        for (int i = 0; i < tmp.size(); i++) {
            if (Math.abs(tmp.get(i)[0] - x) + Math.abs(tmp.get(i)[1] - y) < min) {
                min = Math.abs(tmp.get(i)[0] - x) + Math.abs(tmp.get(i)[1] - y);
                t = tmp.get(i);
                count = i;
            }
        }
        if (count >= 0) {
            for (int i = 0; i < points.length; i++) {
                if(points[i]==t){
                    return i;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }
}
