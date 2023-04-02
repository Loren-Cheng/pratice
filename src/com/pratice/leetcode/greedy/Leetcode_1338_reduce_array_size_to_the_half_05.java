package com.pratice.leetcode.greedy;

import java.util.*;

public class Leetcode_1338_reduce_array_size_to_the_half_05 {
    public int minSetSize(int[] arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        int size = arr.length;
        for (int n : arr
        ) {
            max = Math.max(max, n);
        }
        int[] map = new int[max + 1];

        for (int n : arr
        ) {
            map[n]++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                heap.offer(map[i]);
            }
        }

        while (size > arr.length / 2 && !heap.isEmpty()) {
            size -= heap.poll();
            count++;
        }
        return count;
    }
}
