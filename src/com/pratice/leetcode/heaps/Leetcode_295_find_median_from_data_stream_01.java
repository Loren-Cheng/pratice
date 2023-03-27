package com.pratice.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_295_find_median_from_data_stream_01 {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    //    public MedianFinder() {
    public Leetcode_295_find_median_from_data_stream_01() {

    }

    public void addNum(int num) {
        maxHeap.add(num);
    }

    public double findMedian() {
        int count = maxHeap.size();//
        PriorityQueue<Integer> copyMaxHeap = new PriorityQueue<>(maxHeap);
        int medianCount = (count / 2);//0,1,2,3 size4 medianCount = 2 medianCount1 = 1
        int median = 0;
        int medianCount1 = (count / 2) - 1;//0,1,2,3=>1
        int median1 = 0;
        if (count % 2 == 0) {
            while (copyMaxHeap.size() > medianCount1) {
                int now = copyMaxHeap.poll();

                if (copyMaxHeap.size() == medianCount) {
                    median = now;
                }
                if (copyMaxHeap.size() == medianCount1) {
                    median1 = now;
                }
            }
            return (median + median1) / 2.0;
        } else {
            while (copyMaxHeap.size() > medianCount) {//0,1,2  medianCount = 1 median = 1
                int now = copyMaxHeap.poll();
                if (copyMaxHeap.size() == medianCount) {
                    return now;
                }

            }
        }
        return Integer.MAX_VALUE;
    }
}
