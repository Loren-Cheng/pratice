package com.pratice.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_1338_reduce_array_size_to_the_half_01 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = arr.length;
        int count = 0;

        for (int n : arr
        ) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int n : map.keySet()
        ) {
            heap.offer(n);//n<=arr.length  => runtime<=O(n log(n))
        }

        while (size > arr.length / 2 && !heap.isEmpty()) {
            size -= map.get(heap.poll());
            ++count;
        }
        return count;
    }
}
