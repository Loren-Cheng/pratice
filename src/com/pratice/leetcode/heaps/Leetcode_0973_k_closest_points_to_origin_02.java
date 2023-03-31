package com.pratice.leetcode.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_0973_k_closest_points_to_origin_02 {
    Map<Integer, Integer> distance = new HashMap<>();

    //points[i]的index做為distance的key
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> distance.get(b) - distance.get(a));

        for (int i = 0; i < points.length; i++) {
            distance.put(i, distance(points[i][0], points[i][1]));
        }


        for (int pointIndex : distance.keySet()
        ) {
            heap.offer(pointIndex);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[][] ansArr = new int[k][];
        for (int i = k - 1; i >= 0; i--) {
            ansArr[i] = points[heap.poll()];
        }
        return ansArr;
    }


    static int distance(int x, int y) {
        return x * x + y * y;
    }
}
