package com.pratice.leetcode.greedy;

import java.util.*;

public class Leetcode_1710_maximum_units_on_a_truck_01 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int tmpTruckSize = truckSize;
        int ans = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);

        for (int i = 0; i < boxTypes.length; i++) {
            heap.offer(boxTypes[i]);
        }
        while (true) {
            if (!heap.isEmpty()) {
                int[] boxType = heap.poll();
                int boxCount = boxType[0];
                if (tmpTruckSize >= boxCount) {
                    ans += boxType[1] * boxCount;
                    tmpTruckSize -= boxCount;
                } else if (tmpTruckSize > 0 && tmpTruckSize <= boxCount) {
                    while (tmpTruckSize > 0) {
                        ans += boxType[1];
                        tmpTruckSize--;
                    }
                    break;
                } else {
                    break;
                }
            } else if (heap.isEmpty()) break;
        }
        return ans;
    }
}
