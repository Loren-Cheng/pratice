package com.pratice.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_1338_reduce_array_size_to_the_half_06 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = arr.length;
        int count = 0;

        for (int n : arr
        ) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
//        for (int n : map.keySet()
//        ) {
//            heap.offer(n);//n<=arr.length  => runtime<=O(n log(n))//會浪費時間在比較運算子的map.get()上，poll()時也再查詢一次。
//        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            heap.offer(entry.getValue());//n<=arr.length  => runtime<=O(n log(n))
        }
//        for (int n : map.values()
//        ) {
//            heap.offer(n);//n<=arr.length  => runtime<=O(n log(n))
//        }

        while (size > arr.length / 2 && !heap.isEmpty()) {
            size -= heap.poll();
            ++count;
        }
        return count;
    }
}
