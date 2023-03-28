package com.pratice.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_0703_kth_largest_element_in_a_stream_02 {
    int kth;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

    public Leetcode_0703_kth_largest_element_in_a_stream_02(int k, int[] nums) {
        this.kth = k;
        for (int num : nums
        ) {
            heap.offer(num);
            if (maxHeap.size() < kth) {
                maxHeap.offer(heap.poll());
            } else if ( num > maxHeap.peek()) {
                maxHeap.offer(heap.poll());
                heap.offer(maxHeap.poll());
            }
        }
    }

    public int add(int val) {
        int ans = 0;
        heap.offer(val);
        if (maxHeap.size() < kth) {
            maxHeap.offer(heap.poll());
        } else if ( val > maxHeap.peek()) {
            maxHeap.offer(heap.poll());
            heap.offer(maxHeap.poll());
        }
        return maxHeap.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */