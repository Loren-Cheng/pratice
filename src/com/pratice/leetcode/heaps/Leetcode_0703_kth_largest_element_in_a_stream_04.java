package com.pratice.leetcode.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_0703_kth_largest_element_in_a_stream_04 {
    int kth;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public Leetcode_0703_kth_largest_element_in_a_stream_04(int k, int[] nums) {
        this.kth = k;
        for (int num : nums
        ) {
            add(num);
        }
    }

    public int add(int val) {
        maxHeap.offer(val);
        if (maxHeap.size() > kth) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */