package com.pratice.leetcode.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Leetcode_346_moving_average_from_data_stream_02 {
    //class MovingAverage {
    // original class name is MovingAverage
    int size;
    int curr = 0;
    ArrayDeque<Integer> deque;

    public Leetcode_346_moving_average_from_data_stream_02(int size) {
//    public MovingAverage(int size) {
        this.size = size;
        deque = new ArrayDeque<>();
    }

    public double next(int val) throws InterruptedException {
        curr++;
        while (curr > size) {
            deque.poll();
            curr--;
        }
        deque.offer(val);
        int sum = 0;
        for (int n : deque
        ) {
            sum += n;
        }
        return (double) sum / curr;
    }
}
