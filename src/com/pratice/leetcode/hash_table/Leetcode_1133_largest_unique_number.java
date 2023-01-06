package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1133_largest_unique_number {
    public static int largestUniqueNumber(int[] nums) {
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums
        ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key > max && value == 1) {
                max = entry.getKey();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1}));//8
    }
}
