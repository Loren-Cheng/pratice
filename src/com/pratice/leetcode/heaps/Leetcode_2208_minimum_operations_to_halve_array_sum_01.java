package com.pratice.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_2208_minimum_operations_to_halve_array_sum_01 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        double sum = 0;
        int count = 0;
        for (int num : nums
        ) {
            sum += num;
            maxHeap.add((double) num);
        }
        double heapSum = sum;
        double targetSum = sum / 2;

        while (targetSum < heapSum) {
            if (!maxHeap.isEmpty()) {
                double halfMax = maxHeap.poll() / 2;
                maxHeap.add(halfMax);
                heapSum -= halfMax;
                count++;
            }
        }
        return count;
    }
}
