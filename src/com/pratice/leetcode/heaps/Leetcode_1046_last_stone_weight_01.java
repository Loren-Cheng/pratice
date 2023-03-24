package com.pratice.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_1046_last_stone_weight_01 {
    public int lastStoneWeight(int[] stones) {
        int lastStoneWeight = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int stone : stones
        ) {
            maxHeap.add(stone);
        }
        while (!maxHeap.isEmpty()) {
            int max1 = maxHeap.poll();
            if (!maxHeap.isEmpty()) {
                int max2 = maxHeap.poll();
                if (max1 != max2) {
                    maxHeap.add(max1 - max2);
                }
            } else {
                lastStoneWeight = max1;
            }
        }
        return lastStoneWeight;
    }
}
