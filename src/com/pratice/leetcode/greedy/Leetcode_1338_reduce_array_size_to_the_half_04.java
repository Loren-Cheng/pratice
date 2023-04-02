package com.pratice.leetcode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_1338_reduce_array_size_to_the_half_04 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = arr.length, count = 0;

        for (int n : arr
        ) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        ArrayList<Integer> keyList = new ArrayList<>();
        for (int n : map.keySet()
        ) {
            keyList.add(n);
        }

        Collections.sort(keyList, (a, b) -> map.get(b) - map.get(a));

        for (int i = 0; i < keyList.size(); i++) {
            size -= map.get(keyList.get(i));
            ++count;
            if(size <= arr.length / 2 ){
                break;
            }
        }
        return count;
    }
}
