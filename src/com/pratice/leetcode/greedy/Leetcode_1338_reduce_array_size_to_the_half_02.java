package com.pratice.leetcode.greedy;

import java.util.*;

public class Leetcode_1338_reduce_array_size_to_the_half_02 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = arr.length;
        int count = 0;

        for (int n : arr
        ) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        ArrayList<Integer> keyList = new ArrayList<>();
        for (int n : map.keySet()
        ) {
            keyList.add(n);
        }
        Collections.sort(keyList,(a, b) -> map.get(b) - map.get(a));//~= <= O(n log(n))

        while (size > arr.length / 2 && !keyList.isEmpty()) {
            size -= map.get(keyList.remove(0));//remove will copy to new arr so that cost lots of time
            ++count;
        }
        return count;
    }
}
