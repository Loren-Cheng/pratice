package com.pratice.leetcode.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

// original class name is RecentCounter
public class Leetcode_0933_number_of_recent_calls_01 {
    Queue<Integer> queue;

    public Leetcode_0933_number_of_recent_calls_01() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        queue.offer(t);
        return queue.size();
    }
}
