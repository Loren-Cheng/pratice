package com.pratice.leetcode.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_0973_k_closest_points_to_origin_01 {
    Map<int[], Integer> distance = new HashMap<>();
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b)-> distance.get(b)-distance.get(a));

        for (int[] point : points
        ) {
            distance.put(new int[]{point[0], point[1]}, distance(point[0], point[1]));
        }
        for (int[] point:distance.keySet()
             ) {
            heap.offer(point);
            if(heap.size()>k){
                heap.poll();
            }
        }
        int[][] ansArr = new int[k][];
        for (int i = k-1; i >= 0; i--) {
            ansArr[i] = heap.poll();
        }
        return ansArr;
    }


    static int distance(int x, int y) {
        return x * x + y * y;
    }
}
