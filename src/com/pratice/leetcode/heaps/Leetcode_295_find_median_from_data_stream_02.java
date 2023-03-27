package com.pratice.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_295_find_median_from_data_stream_02 {
    private PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());

    //    public MedianFinder() {
    public Leetcode_295_find_median_from_data_stream_02() {
    }

    public void addNum(int num) {
        rightHeap.add(num);
        leftHeap.add(rightHeap.remove());
        if (leftHeap.size() > rightHeap.size()) {
            rightHeap.add(leftHeap.remove());
        }
    }

    public double findMedian() {
        if (leftHeap.size() == rightHeap.size()) {
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }else{
            return rightHeap.peek();
        }
    }
}
