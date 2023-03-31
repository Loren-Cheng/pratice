package com.pratice.leetcode.heaps;

import java.util.PriorityQueue;

public class Leetcode_0973_k_closest_points_to_origin_03 {
    int[] distance;
    //存下points[i]，第i點的距離平方(比大小不需開根號計算)
    //以Array取代map，不用存下整個點位當做key，減少map的hash()運算量。
    public int[][] kClosest(int[][] points, int k) {
        distance = new int[points.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> distance[b] - distance[a]);

        for (int i = 0; i < points.length; i++) {
            distance[i] = distance(points[i][0], points[i][1]);//O(n)存下distance減少比較運算子的重覆計算。
        }


        for (int j = 0; j < points.length; j++) {
            heap.offer(j);
            if (heap.size() > k) {
                heap.poll();//O(n log(k))
            }
        }

        int[][] ansArr = new int[k][];
        for (int i = k - 1; i >= 0; i--) {
            ansArr[i] = points[heap.poll()];//O(k log(k))
        }
        return ansArr;
    }

    static int distance(int x, int y) {
        return x * x + y * y;
    }
}
//O((n+k)log(k))