package com.pratice.leetcode.heaps;

import java.util.PriorityQueue;

public class Leetcode_1167_minimum_cost_to_connect_sticks_01 {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if (sticks.length == 1) {
            return cost;
        }

        for (int n : sticks
        ) {
            heap.add(n);
        }

        for (int i = 0; i < sticks.length - 1; i++) {
            int n1 = heap.poll();
            int n2 = heap.poll();
            int conStick = n1 + n2;
            cost += conStick;
            heap.add(conStick);
        }
        return cost;
    }
}
