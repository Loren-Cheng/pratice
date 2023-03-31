package com.pratice.leetcode.heaps;

import java.util.PriorityQueue;

public class Leetcode_0973_k_closest_points_to_origin_04 {

    //存下points[i]，第i點的距離平方(比大小不需開根號計算)
    //以Array取代map，不用存下整個點位當做key，減少map的hash()運算量。
    public int[][] kClosest(int[][] points, int k) {

//        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> distance[b] - distance[a]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> distance(points[b][0],points[b][1])-distance(points[a][0],points[a][1]));



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