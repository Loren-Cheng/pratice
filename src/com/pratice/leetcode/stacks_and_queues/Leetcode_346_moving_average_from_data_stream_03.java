package com.pratice.leetcode.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_346_moving_average_from_data_stream_03 {
    //class MovingAverage {
    // original class name is MovingAverage
    int size;
    int curr = 0;
    int sum = 0;
    Deque<Integer> deque;

    public Leetcode_346_moving_average_from_data_stream_03(int size) {
//    public MovingAverage(int size) {
        this.size = size;
        deque = new ArrayDeque<>();
    }

    public double next(int val) throws InterruptedException {
        curr++;
        deque.offer(val);
        sum += val;
        if (curr > size) {
            sum -= deque.poll();
            curr--;
        }
        return (double) sum / curr;
    }
}
