package com.pratice.leetcode.heaps;

import java.util.*;

public class Leetcode_0347_top_k_frequent_elements_01 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ansArr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums
        ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()
        ) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        for (int i = 0; i < k; i++) {
            ansArr[i] = heap.poll();
        }
        return ansArr;
    }
}
