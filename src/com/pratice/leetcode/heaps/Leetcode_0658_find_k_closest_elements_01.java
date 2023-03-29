package com.pratice.leetcode.heaps;

import java.util.*;

public class Leetcode_0658_find_k_closest_elements_01 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ansList = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) ->
        {
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return b - a;
            }
            return Math.abs(b - x) - Math.abs(a - x);
        });
        for (int num : arr
        ) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();//O(n log(k))
            }
        }
        for (int i = 0; i < k; i++) {
            ansList.add(heap.poll());// O(k log(k))
        }
        Collections.sort(ansList);//O(k log(k))
        return ansList;
        //O((n+2k) log(k))=>O((n+k) log(k))
    }

}
