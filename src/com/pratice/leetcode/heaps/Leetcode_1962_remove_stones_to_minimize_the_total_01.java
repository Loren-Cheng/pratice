package com.pratice.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_1962_remove_stones_to_minimize_the_total_01 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int n : piles) {
            heap.offer(n);
        }
        for (int i = 0; i < k; i++) {
            int num = heap.poll();
            int flo = (int) Math.floor(num / 2.0);
            heap.offer(num - flo);
        }
        for (int n : heap) {
            sum += n;
        }
        return sum;
    }
}
