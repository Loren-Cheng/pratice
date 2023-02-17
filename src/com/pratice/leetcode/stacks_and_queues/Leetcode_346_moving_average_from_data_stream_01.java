package com.pratice.leetcode.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_346_moving_average_from_data_stream_01 {
    //class MovingAverage {
    // original class name is MovingAverage
    int windowSize;
    int curr = 0;
    Queue<Integer> queue;

    public Leetcode_346_moving_average_from_data_stream_01(int size) {
//    public MovingAverage(int size) {
        this.windowSize = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (curr < windowSize) {
            curr++;
        }
        while (!queue.isEmpty() && queue.size() >= windowSize) {
            queue.poll();
        }

        queue.offer(val);

        int sum = 0;
        for (int num : queue
        ) {
            sum += num;
        }
        return (double) sum / curr;
    }
}
