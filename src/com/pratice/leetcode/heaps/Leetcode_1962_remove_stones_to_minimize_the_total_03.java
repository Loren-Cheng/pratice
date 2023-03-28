package com.pratice.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_1962_remove_stones_to_minimize_the_total_03 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->b - a);
        int sum = 0;
        for (int n : piles) {
            heap.offer(n);//O(n log(n))
        }
        for (int i = 0; i < k; i++) {
            int num = heap.poll();//O( k log(n))
            int flo =  num - (num/2);//O(k)
            heap.offer(num - flo);//O( k log(n))
        }
        for (int n : heap) {
            sum += n;//O(n)
        }
        return sum;
    }
}
