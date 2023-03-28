package com.pratice.leetcode.heaps;

import java.util.*;

public class Leetcode_0703_kth_largest_element_in_a_stream_01 {
    int kth ;
    PriorityQueue<Integer> heap;
    PriorityQueue<Integer> tmpHeap;
    public Leetcode_0703_kth_largest_element_in_a_stream_01(int k, int[] nums) {
        this.kth = k;
        this.heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num:nums
        ) {
            heap.offer(num);
        }
    }

    public int add(int val) {
        int ans = 0;
        heap.offer(val);
        tmpHeap = new PriorityQueue<>(heap);
        for (int i = 0; i < kth; i++) {
            ans = tmpHeap.poll();
        }
        return ans;
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */