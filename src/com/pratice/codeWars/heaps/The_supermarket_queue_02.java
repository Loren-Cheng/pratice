package com.pratice.codeWars.heaps;

import java.util.PriorityQueue;

public class The_supermarket_queue_02 {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        int time = 0;
        PriorityQueue<Integer> checkout = new PriorityQueue<>();

        for (int minute : customers) {
            if (checkout.size() < n) {
                checkout.add(minute);
            } else {
                int min = checkout.poll() + minute;
                checkout.add(min);
            }
        }

        while (!checkout.isEmpty()) {
            time = checkout.poll();
        }
        return time;
    }
}
