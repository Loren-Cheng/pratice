package com.pratice.codeWars.heaps;

import java.util.PriorityQueue;

public class The_supermarket_queue_01 {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        int time = 0;
        PriorityQueue<Integer> checkout = new PriorityQueue<>();

        for (int minute : customers) {
            checkout.add(minute);
            if (checkout.size() == n) {
                time += checkout.peek();
                checkout = minusMin(checkout);
            }
        }

        while (!checkout.isEmpty()) {
            time += checkout.peek();
            checkout = minusMin(checkout);
        }
        return time;
    }

    static PriorityQueue<Integer> minusMin(PriorityQueue<Integer> checkout) {
        int min = checkout.peek();
        PriorityQueue<Integer> newCheckout = new PriorityQueue<>();
        while (!checkout.isEmpty()) {
            int newTime = checkout.poll();
            if (newTime - min != 0) {
                newCheckout.add(newTime - min);
            }
        }
        return newCheckout;
    }
}
